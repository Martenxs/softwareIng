package modelo;

public class ProductoAlimentos extends Producto implements IPrototype {
    private int calorias;

    public ProductoAlimentos(int id, String descripcion, double precio, int calorias) {
        super(id, descripcion, precio, "Alimento");
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public Producto clonar() {
        return new ProductoAlimentos(id, descripcion, precio, calorias);
    }
}

