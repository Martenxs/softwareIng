package modelo;

public abstract class CarritoDecorator implements CarritoCompra {
    protected CarritoCompra carrito;

    public CarritoDecorator(CarritoCompra carrito) {
        this.carrito = carrito;
    }

    @Override
    public String obtenerDescripcion() {
        return carrito.obtenerDescripcion();
    }

    @Override
    public double calcularTotal() {
        return carrito.calcularTotal();
    }
}
