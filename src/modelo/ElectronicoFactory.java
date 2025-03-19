package modelo;

public class ElectronicoFactory {
    public static Producto crearProducto(int id, String descripcion, double precio, double voltajeEntrada) {
        return new ProductoElectronico(id, descripcion, precio, voltajeEntrada);
    }
}
