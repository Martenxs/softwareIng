package modelo;

// Subclase Envío Internacional
public class EnvioInternacional extends Envio {
    public EnvioInternacional(Mercancia mercancia) {
        super(mercancia);
    }

    public String enviar() {
        return "Envío Internacion al de " + mercancia.tipo();
    }
}
