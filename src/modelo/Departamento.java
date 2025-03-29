package modelo;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Componente {
    private String nombre;
    private List<Componente> componentes;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregar(Componente componente) {
        componentes.add(componente);
    }

    public void eliminar(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public String obtenerInformacion() {
        StringBuilder info = new StringBuilder("Departamento: " + nombre + "\n");
        for (Componente componente : componentes) {
            info.append("  - ").append(componente.obtenerInformacion()).append("\n");
        }
        return info.toString();
    }
}
