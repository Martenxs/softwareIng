package modelo;

public class EnvioNacional extends Envio{
    public EnvioNacional(Mercancia mercancia){
        super(mercancia);

    }
    @Override
    public String procesarEnvio(){
        return "Envio Nacional" +  mercancia.obtenerTipo();
    }
}
