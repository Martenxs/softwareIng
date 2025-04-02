package modelo;

// Implementación base del Carrito
public class CarritoBase implements Carrito {
    public String descripcion() {
        return "Carrito de compras";
    }

    public double costo() {
        return 100.0;  // Precio base
    }
}
