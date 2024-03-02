package domain;

public class Plato {
    //Atributos
    private String nombre;
    private int precio;
    private int cantidad;
    private int inventario;

    //Constructor
    public Plato() {

    }

    //Métodos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getInventario() {
        return inventario;
    }
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    public void reducirInventario() {
        this.inventario -= 1;
    }
}
