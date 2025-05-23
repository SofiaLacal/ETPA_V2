package modelo;

public class Jugador {

    //TODO Atributos

    private String nombreJugador;
    private String contraseña;
    private int puntos;
    private String personajeElegido;


    //TODO Constructores

    public Jugador(String nombre, String contraseña, int puntos, String personajeElegido) {
        this.nombreJugador = nombre;
        this.contraseña = contraseña;
        this.puntos = puntos;
        this.personajeElegido = personajeElegido;
    }

    public Jugador () {

    }

     //Getters & Setters

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
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

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getPersonajeElegido() {
        return personajeElegido;
    }

    public void setPersonajeElegido(String personajeElegido) {
        this.personajeElegido = personajeElegido;
    }


    //TODO Otros métodos

    public String toString () {

        String cadenaInfo;

        cadenaInfo = "" + "" + "" + "";

        return cadenaInfo;
    }

    public void infoJugador () {
        
    }
 
    public void sumarPuntos (int puntos) {
        
        this.puntos += puntos;
    }

    public String estadisticasString () {

        Jugador jugador = new Jugador();

        String cadenaEstadisticas;

        cadenaEstadisticas = "Los puntos del jugador " + jugador.getNombreJugador() + " son: ";

        return cadenaEstadisticas;

    }

    


   

    


}
