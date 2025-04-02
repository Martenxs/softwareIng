package modelo;

// Subclase Envío Nacional
public class EnvioNacional extends Envio {
    public EnvioNacional(Mercancia mercancia) {
        super(mercancia);
    }

    public String enviar() {
        return "Envío Nacional de " + mercancia.tipo();
    }
}

