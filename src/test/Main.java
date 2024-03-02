package test;

import domain.Cliente;
import domain.Factura;
import domain.Mesa;
import domain.Restaurante;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner consola = new Scanner(System.in);
    static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

    static {
        //Creamos sedes por defecto
        restaurantes.add(new Restaurante("Medellín", true));
        restaurantes.add(new Restaurante("Bogotá", false));

        //Crear mesas por defecto
        for (Restaurante restaurante : restaurantes) {
            if (restaurante.isZonaVIP()) {
                for (int i = 0; i < 10; i++) {
                    restaurante.mesas.add(new Mesa());
                    restaurante.mesas.getLast().setRestaurante(restaurante);
                }
                for (int i = 0; i < 5; i++) {
                    restaurante.mesas.add(new Mesa());
                    restaurante.mesas.getLast().setRestaurante(restaurante);
                    restaurante.mesas.getLast().setEnZonaVIP(true);
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    restaurante.mesas.add(new Mesa());
                    restaurante.mesas.getLast().setRestaurante(restaurante);
                }
            }
        }
    }
    public static void main(String[] args) {
        boolean encendido = true;
        String accion;
        do {
            System.out.println("¿Qué acción desea realizar? [1-2] \n1 - Reservar \n2 - Salir");
            accion = readString();
            switch (accion) {
                case "1":
                    reservarMesa();
                    break;
                case "2":
                    System.out.println("Vuelva pronto");
                    encendido = false;
                    break;
                default:
                    System.out.println("Recuerde escribir un número del 1 al 2 según guste");
                    break;
            }
        } while (encendido);

    }

    static String readString() {
        return consola.nextLine();
    }

    static int readInt() {
        return Integer.parseInt(consola.nextLine());
    }

    //Funcionalidad #1
    static void reservarMesa() {
        //Preguntamos en qué ciudad se desea hacer la reserva
        Cliente clienteActual = null;
        Restaurante restauranteActual = null;
        boolean encendido = true;
        do {
            System.out.println("Seleccione la ciudad donde se realizará la reserva [1-2]\n1 - Medellín\n2 - Bogotá\n3 - Regresar");
            String accion = readString();
            switch (accion) {
                case "1":
                    restauranteActual = restaurantes.get(0);
                    clienteActual = Restaurante.crearCliente(restauranteActual);
                    encendido = false;
                    break;
                case "2":
                    restauranteActual = restaurantes.get(1);
                    clienteActual = Restaurante.crearCliente(restauranteActual);
                    encendido = false;
                    break;
                case "3":
                    encendido = false;
                    break;
                default:
                    System.out.println("Recuerde escribir un número del 1 al 2 según guste");
                    break;
            }
        } while (encendido);

        //Llamamos al método establecerMesa (Interacción #2)
        Mesa mesaActual = Restaurante.establecerMesa(clienteActual);

        //Lamamos al método pagoPrevio (Interacción #3)
        Factura facturaActual = Restaurante.pagoPrevio(mesaActual, clienteActual);

        //Imprimimos el resumen de la reserva
        System.out.println(clienteActual.toString());
    }
}
