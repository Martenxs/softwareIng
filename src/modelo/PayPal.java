package modelo;

public class PayPal {
    private int cedula;

    public PayPal(int cedula) {
        this.cedula = cedula;
    }

    public String hacerPagoPayPal(double cantidad) {
        return "Pago de $" + cantidad + " realizado con PayPal con cédula: " + cedula;
    }
}
