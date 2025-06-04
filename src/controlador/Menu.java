package controlador;

import modelo.Batalla;
import modelo.Escenarios;
import modelo.Personaje;
import modelo.Rompecabezas;
import personajes.Anuket;
import personajes.Bastet;
import personajes.Cambises;

import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {

        Personaje personajeSeleccionado = null;
        

        Scanner sc = new Scanner(System.in);

        System.out.println("\nVamos a comenzar la aventura, debes ir eligiendo tu propio camino." 
        	+ "\n¡¡Pero cuidado!! \nTus decisiones pueden afectar al desenlace final.\n" 
        	+ "\nRecibes un mensaje de los Dioses avisando de un peligro inminente." 
        	+ "\nTaharka, nigromante exiliado en los tiempos de Amunoketh II, ha regresado. Debe ser detenido a toda costa para evitar la destrucción de Egipto.");

        System.out.println("\nElige a tu personaje:\n");

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
        /*
        //Rompecabezas
        Rompecabezas rompeUno = new Rompecabezas();
        rompeUno.iniciarJuegos(rompeUno);
        */
        //Escenario
        Escenarios escenario = Escenarios.getInstancia();

        // Iniciar batalla normal
        Batalla.iniciarBatallaNormal(personajeSeleccionado, escenario);
        Batalla.iniciarBatallaFinal(personajeSeleccionado, escenario);

        sc.close();
    }
        
}