package modelo;

public class CarritoBase implements CarritoCompra{
    private double total;
    public CarritoBase(double total){
        this.total = total;
    }
    @Override
    public String obtenerDescripcion(){
        return "Carrito de compra";
    }
    @Override
    public double calcularTotal(){
        return total;
    }
}
