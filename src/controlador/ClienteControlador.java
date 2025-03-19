package controlador;

import modelo.Cliente;
import servicios.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class ClienteControlador {
    private ClienteDAO clienteDAO;

    public ClienteControlador() throws SQLException {
        this.clienteDAO = new ClienteDAO();
    }

    public void agregarCliente(String id, String nombre) throws SQLException {
        Cliente cliente = new Cliente(id, nombre);
        clienteDAO.create(cliente);
    }

    public List<Cliente> listarClientes() throws SQLException {
        return clienteDAO.read();
    }

    public Cliente buscarCliente(String id) throws SQLException {
        return clienteDAO.read(id);
    }

    public void actualizarCliente(String id, String nuevoNombre) throws SQLException {
        Cliente cliente = new Cliente(id, nuevoNombre);
        clienteDAO.update(id, cliente);
    }

    public void eliminarCliente(String id) throws SQLException {
        clienteDAO.delete(id);
    }
}
//patron builder y patron object pool
