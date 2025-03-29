package modelo;

import java.util.List;

public class Proveedor {
    private String nombre;
    private String contacto;
    private List<Certificacion> certificaciones;
    private Evaluacion evaluacion;
    private PoliticaEntrega politicaEntrega;

    private Proveedor(Builder builder) {
        this.nombre = builder.nombre;
        this.contacto = builder.contacto;
        this.certificaciones = builder.certificaciones;
        this.evaluacion = builder.evaluacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

    // Clase interna para la política de entrega
    public static class PoliticaEntrega {
        private String tiempoEntrega;
        private boolean devolucionesPermitidas;

        public PoliticaEntrega(String tiempoEntrega, boolean devolucionesPermitidas) {
            this.tiempoEntrega = tiempoEntrega;
            this.devolucionesPermitidas = devolucionesPermitidas;
        }
    }

    // Builder para construir instancias de Proveedor
    public static class Builder {
        private String nombre;
        private String contacto;
        private List<Certificacion> certificaciones;
        private Evaluacion evaluacion;
        private PoliticaEntrega politicaEntrega;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setContacto(String contacto) {
            this.contacto = contacto;
            return this;
        }

        public Builder setCertificaciones(List<Certificacion> certificaciones) {
            this.certificaciones = certificaciones;
            return this;
        }

        public Builder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
            this.politicaEntrega = politicaEntrega;
            return this;
        }

        public Proveedor build() {
            return new Proveedor(this);
        }
    }
}
