package modelo;

import java.util.List;

public class Pedido {
    private String numero;
    private String fecha;
    private Cliente cliente;
    private List<Producto> productos;

    public Pedido(String numero, String fecha, Cliente cliente, List<Producto> productos) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
    }

    public String getNumero() { return numero; }
    public String getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return productos; }
}
