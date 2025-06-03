package controlador;

import modelo.Batalla;
import modelo.Personaje;
import modelo.Rompecabezas;
import personajes.Anuket;
import personajes.Bastet;
import personajes.Cambises;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
/* 
        Personaje personajeSeleccionado = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a la Aventura del Nilo!");
        System.out.print("Introduce tu nombre, valiente viajero: ");
        String nombreJugador = sc.nextLine();

        System.out.println("\nHola " + nombreJugador + ", elige tu personaje:");

        do {

            System.out.println("1. Cambises - Maestro del fuego");
            System.out.println("2. Bastet - Diosa de la protección y la luz");
            System.out.println("3. Ánuket - Guardiana del agua y el rayo");
            System.out.print("Escoge uno de los tres personajes: ");

            int eleccion = sc.nextInt();

            switch (eleccion) {
                case 1 : 
                    personajeSeleccionado = new Cambises();
                    break;
                case 2 : 
                    personajeSeleccionado = new Bastet();
                    break;
                case 3 : 
                    personajeSeleccionado = new Anuket();
                    break;
                default : 
                    System.out.println("\nSELECCIÓN INVALIDA. INTENTE NUEVAMENTE.\n");
            }
        } while (personajeSeleccionado == null);

        System.out.println("\nHas elegido a: " + personajeSeleccionado.getNombre());
        System.out.println("¡Prepárate para tu primera batalla!");

        // Iniciar batalla
        Batalla batalla = new Batalla(personajeSeleccionado);
        batalla.iniciar();

        System.out.println("\nGracias por jugar, " + nombreJugador + "!");

        sc.close();
    }

    */

        Rompecabezas rompe = new Rompecabezas();

        rompe.IniciarJuegos(rompe);

    }
}
