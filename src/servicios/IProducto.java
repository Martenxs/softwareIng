package servicios;

import modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProducto {
    List<Producto> buscarPorRangoDePrecio(double min, double max) throws SQLException;
}
