package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import dao.DaoJugador;
import modelo.Jugador;
import modelo.Rompecabezas;



public class Juego {

	public static void main(String[] args) throws SQLException {

		/*
		Jugador jugador1 = new Jugador();
    	DaoJugador dao1 = new DaoJugador();
		*/
    	Rompecabezas rompe = new Rompecabezas();
    	/* 
    	try {
			Jugador.crearJugador();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la base de datos.");
			e.printStackTrace();
		}
    	*/
    	rompe.iniciarJuegos(rompe);



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
