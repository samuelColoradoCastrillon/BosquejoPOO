package domain;

public class Mesa {
    //Atributos
    private Factura factura;
    private int numMesa;
    private int numAsientos = 4;
    private Cliente cliente;
    private Restaurante restaurante;
    private boolean enZonaVIP;
    public static int contadorMesa = 1;

    //Constructor
    public Mesa() {
        this.numMesa = contadorMesa++;
    }

    //Métodos
    public int getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }
    public int getNumAsientos() {
        return numAsientos;
    }
    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    public boolean isEnZonaVIP() {
        return enZonaVIP;
    }
    public void setEnZonaVIP(boolean enZonaVIP) {
        this.enZonaVIP = enZonaVIP;
    }
    public String tipoMesa() {
        if (enZonaVIP) {
            return "Mesa VIP";
        } else {
            return "Mesa Estándar";
        }
    }
}
