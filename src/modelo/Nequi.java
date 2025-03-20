package modelo;

public class Nequi {
    private String correo;

    public Nequi(String correo) {
        this.correo = correo;
    }

    public String pagarConNequi(double cantidad) {
        return "Pago de $" + cantidad + " realizado con Nequi desde el correo: " + correo;
    }
}
