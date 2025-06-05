package controlador;

import modelo.Batalla;
import modelo.Escenarios;
import modelo.Jugador;
import modelo.Personaje;
import modelo.Rompecabezas;
import personajes.Anuket;
import personajes.Bastet;
import personajes.Cambises;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    
        public void iniciarPartida(){

            try {
    		
            Jugador jugador = Jugador.crearJugador();

            System.out.println("\nVamos a comenzar la aventura, debes ir eligiendo tu propio camino." 
                	+ "\n¡¡Pero cuidado!! \nTus decisiones pueden afectar al desenlace final.\n" 
                	+ "\nRecibes un mensaje de los Dioses avisando de un peligro inminente." 
                	+ "\nTaharka, nigromante exiliado en los tiempos de Amunoketh II, ha regresado. Debe ser detenido a toda costa para evitar la destrucción de Egipto.");
            
            //ELEGIR PERSONAJE
            
            Personaje personajeSeleccionado = null;
            Scanner sc = new Scanner(System.in);

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
            
            //INICIAMOS ROMEPCABEZAS
            Rompecabezas rompe = new Rompecabezas();
            rompe.iniciarJuegos(jugador);           

            
            //INICIAMOS BATALLA
            
        //personajeSeleccionado.activarFinal(3);

        Escenarios escenario = Escenarios.getInstancia();

        Batalla.iniciarBatallaNormal(personajeSeleccionado, escenario);
        Batalla.iniciarBatallaFinal(personajeSeleccionado, escenario);
            
        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos.");
            e.printStackTrace();
        }	
    }   
}