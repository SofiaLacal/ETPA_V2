package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Jugador;

public class DaoJugador {

	//TODO Atributos
	
	private Connection conn = null;
	
	private static DaoJugador instance = null;
	
	
	//TODO Constructores
	
	public DaoJugador () throws SQLException {
		
		conn = DBManager.getConnection();
	}
	
	
	//TODO Otros métodos
	
	//1. Método para insertar jugadores
    public void insert (Jugador jugadorIn) throws SQLException {
		
		//Consulta de SQL para inserción de datos
		String insertSql = "INSERT INTO JUGADOR (nombreJugador, contrasenia, puntos) VALUES (?,?,?)";
					
		//Relación con query dinámica
		PreparedStatement statement = conn.prepareStatement(insertSql);

		//Datos para la consulta
		statement.setString(1, jugadorIn.getNombreJugador());
		statement.setString(2, jugadorIn.getContraseña());
		statement.setInt(3, jugadorIn.getPuntos());
		
		//Inserción de datos					
		int recordsInserted = statement.executeUpdate();

		//Comprobación	
		if (recordsInserted > 0) {
			
		} else {
			System.out.println("Error al crear el usuario\n");
		}

		//Cerramos el INSERT
		statement.close();
    }
	
    //2. Método para verificar si el jugador ya existe en la BD
    public boolean existe(String nombre) throws SQLException {

        String sql = "SELECT COUNT(*) FROM jugador WHERE nombreJugador = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    //Actualización de puntos en ls BD
    public void update () throws SQLException {
		
    	Jugador jugador = new Jugador();

		//Consulta de SQL para actualizar datos
		String updateSql = "UPDATE jugador SET puntos=? WHERE nombreJugador=?";
		
		//Relaciono con query dinámica
		PreparedStatement statementUpdate = conn.prepareStatement(updateSql);
		
		//Datos necesarios para hacer la consulta
		statementUpdate.setInt(1, jugador.getPuntos());

		//Ejecuto la consulta
		int regsUpdated = statementUpdate.executeUpdate();
		
		//Compruebo si la actualización se ha realizado con éxito
		if (regsUpdated > 0) {
			System.out.println("\nActualización realizada con éxito\n");
		
		} else {
			System.out.println("Algo ha fallado en la actualización\n");
		}
		
		//Cierro el UPDATE
		statementUpdate.close();		
	}
}
	

