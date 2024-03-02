package domain;

public class Cliente {
    //Atributos
    private Factura factura;
    private int cedula;
    private int numPersonas;
    private String nombre;
    private Mesa mesa;
    private Restaurante restaurante;

    //Constructor
    public Cliente() {

    }

    //Métodos
    public int getNumPersonas() {
        return numPersonas;
    }
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Resumen Reserva:");
        sb.append("\nNombre del responsable: ").append(nombre);
        sb.append("\nCedula: ").append(cedula);
        sb.append("\nNúmero de personas: ").append(numPersonas);
        sb.append("\nRestaurante: ").append("Sede ").append(restaurante.getCiudad());
        sb.append("\nMesa: ").append(mesa.tipoMesa()).append(" Número ").append(mesa.getNumMesa());
        sb.append("\nFactura actual: ").append(factura.getValor());
        return sb.toString();
    }
}
