package modelo;

public class EnvioGratisDecorator extends CarritoDecorator {
    public EnvioGratisDecorator(CarritoCompra carrito) {
        super(carrito);
    }

    @Override
    public String obtenerDescripcion() {
        return carrito.obtenerDescripcion() + " + Envío Gratis";
    }

    @Override
    public double calcularTotal() {
        return carrito.calcularTotal(); // No afecta el costo total
    }
}
