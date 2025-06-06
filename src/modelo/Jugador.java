package modelo;

import java.sql.SQLException;
import java.util.Scanner;
import dao.DaoJugador;

public class Jugador {

    //TODO Atributos

    private String nombreJugador;
    private String contraseña;
    private int puntos;

    //TODO Constructores

    public Jugador(String nombre, String contraseña, int puntos) {
        this.nombreJugador = nombre;
        this.contraseña = contraseña;
        this.puntos = puntos;
    }

    
    //Getters & Setters

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPuntos() {
        return puntos;
    }

    //TODO Otros métodos    
    
    //1. Método para crear jugador nuevo
    public static Jugador crearJugador() throws SQLException {
        
    	Scanner sc = new Scanner(System.in);

    	System.out.println("                     Bienvenido a                           \n");
		System.out.println("             山卂尺尺丨ㄖ尺丂 ㄖ千 乇卂乙丨爪卂                   \n");
		System.out.println("         Sofia Lacal, Javier Monzón, Harley Mena             \n");
		System.out.println("       ...........................................           \n");
		
        System.out.print("Dime tu nombre: ");
        String nombre = sc.nextLine().toUpperCase();

        DaoJugador daoJugador = new DaoJugador();

        if (daoJugador.existe(nombre)) {
            // LOGIN
            String contraseñaReal = daoJugador.obtenerContraseña(nombre);
            int puntos = daoJugador.obtenerPuntos(nombre);

            Jugador jugadorExistente = new Jugador(nombre, contraseñaReal, puntos);
            jugadorExistente.verificarContraseña();

            return jugadorExistente;

        } else {
            // REGISTRO
            String pass, confirmar;

            do {
                System.out.print("Crea una contraseña: ");
                pass = sc.nextLine();
                System.out.print("Confirma la contraseña: ");
                confirmar = sc.nextLine();

                if (!pass.equals(confirmar)) {
                    System.out.println("Las contraseñas no coinciden");
                }

            } while (!pass.equals(confirmar));

            Jugador nuevoJugador = new Jugador(nombre, pass, 0);
            daoJugador.insert(nuevoJugador);
            
            System.out.println("Usuario registrado con éxito");
            
            return nuevoJugador;
        }
    }
    

    //2. Método para verificar la contraseña
    public void verificarContraseña() {

        Scanner sc = new Scanner(System.in);
        String intento;
        
        do {
            System.out.print("Introduce tu contraseña: ");
            intento = sc.nextLine();

            if (!this.contraseña.equals(intento)) {
                System.out.println("Las contraseña no coinciden. Inténtalo de nuevo.");
            }

        } while (!this.contraseña.equals(intento));

        System.out.println("Contraseña correcta. ¡Bienvenid@ al juego, " + this.nombreJugador + "!");
    }

    
    //3. toString + imprimirlo
    public String toString () {

        return "\n-------------------------------" + "\nNombre del jugador: " + getNombreJugador() + 
        		"\nPuntos: " + getPuntos() + "\n-------------------------------";
    }

    public void infoJugador () {

        System.out.println(toString());
    }
 

    //4. Método para sumar los puntos del usuario
    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }
    

    //5. Información de los puntos del jugador
    
    public int infoPuntos () {

        return this.puntos;
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
	    }
	    
*/





