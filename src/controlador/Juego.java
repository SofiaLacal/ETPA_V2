package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import modelo.Batalla;
import modelo.Jugador;
import modelo.Personaje;
import modelo.Rompecabezas;
import personajes.Anuket;
import personajes.Bastet;
import personajes.Cambises;

import java.sql.SQLException;
import java.util.Scanner;

import dao.DaoJugador;

public class Juego {

    public static void main(String[] args) throws SQLException {

    	try {
            Jugador jugador = Jugador.crearJugador();

            Rompecabezas rompe = new Rompecabezas();
            rompe.iniciarJuegos(jugador);

        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos.");
            e.printStackTrace();
        }
    	
    }

		/* 
		 try {
	            Scanner sc = new Scanner(System.in);
	            DaoJugador dao = new DaoJugador();

	            // Crear o recuperar jugador
	            Jugador jugador = Jugador.crearJugador();

	            // Mostrar datos del jugador
	            jugador.infoJugador();

	            System.out.println("");
	            
	            // Simulación de ganar puntos
	            System.out.print("Has superado un reto. ¿Cuántos puntos has ganado?: ");
	            int puntosGanados = sc.nextInt();
	            sc.nextLine();
	            jugador.sumarPuntos(puntosGanados);

	            // Actualizar puntuación en BD
	            dao.actualizarPuntos(jugador);

	            // Mostrar ranking actualizado
	            dao.mostrarRanking();

	        } catch (SQLException e) {
	            System.out.println("Error al acceder a la base de datos.");
	            e.printStackTrace();
	        }
			*/
		 
	    }
	
}
