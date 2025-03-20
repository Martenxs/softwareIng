package controlador;

import modelo.*;

public class PagoControlador {

    private Pago pago;

    public String procesarPago(String metodo, double monto) {
        if (metodo.equals("Nequi")) {
            pago = new NequiAdapter(new Nequi("diego@gmail.com"));
        } else {
            pago = new PayPalAdapter(new PayPal(1071162531));
        }

        // Capturar el resultado del pago y retornarlo
        return pago.realizarPago(monto);
    }
}
