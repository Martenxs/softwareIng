package modelo;

public interface ProductoFactory {
    Producto crearProducto(String id, String descripcion, double precio, double atributoEspecifico);
}
