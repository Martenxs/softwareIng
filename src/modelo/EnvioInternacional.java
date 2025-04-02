package modelo;

public class EnvioInternacional extends  Envio{
    public EnvioInternacional(Mercancia mercancia){
        super(mercancia);
    }
    @Override
    public String procesarEnvio(){
        return "Envio internacional de" + mercancia.obtenerTipo();
    }
}
