package modelo;

// Abstracción de Envío
public abstract class Envio {
    protected Mercancia mercancia;

    public Envio(Mercancia mercancia) {
        this.mercancia = mercancia;
    }

    public abstract String enviar();
}
