package modelo;

public class NequiAdapter implements Pago {
    private Nequi nequi;

    public NequiAdapter(Nequi nequi) {
        this.nequi = nequi;
    }

    @Override
    public void realizarPago(double monto) {
        nequi.pagarConNequi(monto);
    }
}