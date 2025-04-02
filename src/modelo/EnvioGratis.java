package modelo;

// Decorador: Envío Gratis
public class EnvioGratis extends CarritoDecorator {
    public EnvioGratis(Carrito carrito) {
        super(carrito);
    }

    public String descripcion() {
        return super.descripcion() + " + Envío Gratis";
    }

    public double costo() {
        return super.costo();  // No cambia el precio
    }
}
