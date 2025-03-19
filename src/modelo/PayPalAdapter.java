package modelo;

public class PayPalAdapter implements Pago {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void realizarPago(double monto) {
        paypal.hacerPagoPayPal(monto);
    }
}