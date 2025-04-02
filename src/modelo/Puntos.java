package modelo;

// Decorador: Puntos de recompensa
public class Puntos extends CarritoDecorator {
    public Puntos(Carrito carrito) {
        super(carrito);
    }

    public String descripcion() {
        return super.descripcion() + " + Acumulación de Puntos";
    }

    public double costo() {
        return super.costo();  // No cambia el precio
    }
}
