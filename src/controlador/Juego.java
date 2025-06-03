package controlador;

import java.sql.SQLException;

import dao.DaoJugador;
import modelo.Jugador;



public class Juego {

	public static void main(String[] args) throws SQLException {
		
		Jugador jugador = Jugador.crearJugador();

        try {
			DaoJugador daoJugador = new DaoJugador();
			daoJugador.insert(jugador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        jugador.infoJugador();
        
        jugador.setPuntos(50);
        jugador.sumarPuntos(20);
        
        jugador.infoPuntos();
        
	}
	
}
