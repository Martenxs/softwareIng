package servicios;

import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements PatronDAO<Cliente> {
    private Connection conn;

    public ClienteDAO() throws SQLException {
        conn = Singleton.getInstance().getConnection();
    }

    @Override
    public void create(Cliente obj) throws SQLException {
        String sql = "INSERT INTO cliente (id, nombre) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getId());
            stmt.setString(2, obj.getNombre());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Cliente> read() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString("id"), rs.getString("nombre")));
            }
        }
        return clientes;
    }

    @Override
    public Cliente read(String id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getString("id"), rs.getString("nombre"));
            }
        }
        return null;
    }

    @Override
    public void update(String id, Cliente obj) throws SQLException {
        String sql = "UPDATE cliente SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNombre());
            stmt.setString(2, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
