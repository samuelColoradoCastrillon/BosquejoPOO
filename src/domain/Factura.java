package domain;

import java.util.ArrayList;

public class Factura {
    //Atributos
    private int valor;
    private String metodoPago;
    private Mesa mesa;
    private ArrayList<Plato> platos;

    //Constructor
    public Factura() {

    }

    //Métodos
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void aumentarValor(int valor) {
        this.valor += valor;
    }
}
