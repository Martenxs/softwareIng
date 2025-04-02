package modelo;

// Decorador: Descuento
public class Descuento extends CarritoDecorator {
    public Descuento(Carrito carrito) {
        super(carrito);
    }

    public String descripcion() {
        return super.descripcion() + " + Descuento aplicado";
    }

    public double costo() {
        return super.costo() * 0.9;  // 10% de descuento
    }
}
