package modelo;

public abstract class Producto {
    protected int id;
    protected String descripcion;
    protected double precio;
    protected String tipo;

    public Producto(int id, String descripcion, double precio, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }
}


