package modelo;

public class AlimentoFactory {
    public static ProductoAlimentos crearProducto(int id, String descripcion, double precio, int calorias) {
        return new ProductoAlimentos(id, descripcion, precio, calorias);
    }
}

