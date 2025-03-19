package modelo;

public class ProductoElectronico extends Producto implements IPrototype {
    private double voltajeEntrada;

    public ProductoElectronico(int id, String descripcion, double precio, double voltajeEntrada) {
        super(id, descripcion, precio, "Electronico");
        this.voltajeEntrada = voltajeEntrada;
    }

    public double getVoltajeEntrada() {
        return voltajeEntrada;
    }

    @Override
    public Producto clonar() {
        return new ProductoElectronico(id, descripcion, precio, voltajeEntrada);
    }
}


