package modelo;

public class DescuentoDecorator extends CarritoDecorator {
    private double descuento;

    public DescuentoDecorator(CarritoCompra carrito, double descuento) {
        super(carrito);
        this.descuento = descuento;
    }

    @Override
    public String obtenerDescripcion() {
        return carrito.obtenerDescripcion() + " + Descuento de " + descuento + "%";
    }

    @Override
    public double calcularTotal() {
        return carrito.calcularTotal() * (1 - descuento / 100);
    }
}
