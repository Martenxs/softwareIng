package controlador;

import modelo.Producto;
import modelo.IPrototype;
import servicios.ProductoDAO;
import java.sql.Connection;
import java.util.List;

public class ProductoControlador {
    private ProductoDAO productoDAO;

    public ProductoControlador(Connection conexion) {
        this.productoDAO = new ProductoDAO(conexion);
    }

    public void agregarProducto(Producto producto) {
        productoDAO.create(producto);
    }

    public List<Producto> obtenerProductos() {
        return productoDAO.obtenerTodos();
    }

    public Producto clonarProducto(Producto producto) {
        if (producto instanceof IPrototype) {
            return ((IPrototype) producto).clonar();
        } else {
            throw new IllegalArgumentException("El producto no soporta clonación");
        }
    }

    public List<Producto> buscarPorRangoDePrecio(double min, double max) {
        return productoDAO.buscarPorRangoDePrecio(min, max);
    }
}

