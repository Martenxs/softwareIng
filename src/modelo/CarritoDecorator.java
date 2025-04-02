package modelo;

// Decorador base
public abstract class CarritoDecorator implements Carrito {
    protected Carrito carrito;

    public CarritoDecorator(Carrito carrito) {
        this.carrito = carrito;
    }

    public String descripcion() {
        return carrito.descripcion();
    }

    public double costo() {
        return carrito.costo();
    }
}
