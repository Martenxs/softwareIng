package modelo;

public class PuntosDecorator extends CarritoDecorator {
    private int puntos;

    public PuntosDecorator(CarritoCompra carrito, int puntos) {
        super(carrito);
        this.puntos = puntos;
    }

    @Override
    public String obtenerDescripcion() {
        return carrito.obtenerDescripcion() + " + " + puntos + " puntos acumulados";
    }

    @Override
    public double calcularTotal() {
        return carrito.calcularTotal(); // No afecta el costo total
    }
}
