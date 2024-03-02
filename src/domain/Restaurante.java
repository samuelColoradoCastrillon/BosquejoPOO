package domain;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    //Atributos
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Plato> menu = new ArrayList<Plato>();
    public static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private String ciudad;
    private boolean zonaVIP;

    //Constructor
    public Restaurante(String ciudad, boolean zonaVIP) {
        this.ciudad = ciudad;
        this.zonaVIP = zonaVIP;
    }

    //Métodos
    static Scanner consola = new Scanner(System.in);
    static String readString() {
        return consola.nextLine();
    }
    static int readInt() {
        return Integer.parseInt(consola.nextLine());
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public ArrayList<Plato> getMenu() {
        return menu;
    }
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    public boolean isZonaVIP() {
        return zonaVIP;
    }
    public void setZonaVIP(boolean zonaVIP) {
        this.zonaVIP = zonaVIP;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    //FUNCIONALIDAD NUMERO 1: RESERVAR
    //Primera Interacción: crearCliente
    public static Cliente crearCliente(Restaurante restauranteActual) {
        //Soliciamos los datos básicos del cliente.
        restauranteActual.clientes.add(new Cliente());
        Cliente clienteActual = restauranteActual.clientes.getLast();
        System.out.println("Ingrese los datos del cliente:");
        System.out.println("Nombre del responsable: ");
        clienteActual.setNombre(readString());
        System.out.println("Número de documento del responsable: ");
        clienteActual.setCedula(readInt());
        System.out.println("¿Cuántas personas son en total?: ");
        clienteActual.setNumPersonas(readInt());
        clienteActual.setRestaurante(restauranteActual);
        return clienteActual;
    }
    //Segunda Interacción: establecerMesa
    public static Mesa establecerMesa(Cliente clienteActual) {
        System.out.println("¿Qué mesa se reservará?\nA continuación se muestra una lista de las mesas disponibles:");

        for (Mesa mesa : mesas) {
            if (mesa.getCliente() == null && mesa.getRestaurante() == clienteActual.getRestaurante()) {
                System.out.println(mesa.tipoMesa() + " Número " + mesa.getNumMesa());
            }
        }
        Mesa mesaActual = mesas.get(readInt() - 1);
        mesaActual.setCliente(clienteActual);
        clienteActual.setMesa(mesaActual);
        return mesaActual;
    }
    //Tercera Interacción: pagoPrevio
    public static Factura pagoPrevio(Mesa mesaActual, Cliente clienteActual) {
        Factura facturaActual = new Factura();
        if (mesaActual.isEnZonaVIP()) {
            facturaActual.aumentarValor(10000);
        } else {
            facturaActual.aumentarValor(2000);
        }
        mesaActual.setFactura(facturaActual);
        clienteActual.setFactura(facturaActual);
        return facturaActual;
    }
}
