package modelo;

public class Empleado implements Componente {
    private String nombre;
    private String cargo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    @Override
    public String obtenerInformacion() {
        return "Empleado: " + nombre + ", Cargo: " + cargo;
    }
}
