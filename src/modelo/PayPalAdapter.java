package modelo;

public class PayPalAdapter implements Pago {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public String realizarPago(double monto) {
        paypal.hacerPagoPayPal(monto);
        return "Pago realizado con PayPal.";
    }
}
