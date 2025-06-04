package modelo;

import java.util.Random;

public class Ataque {

    //TODO Atributos

    private String nombreAtaque;
    private int danioCompleto;
    private int danioParcial;
    private int danioNulo;

    //TODO Contructor

    public Ataque(String nombreAtaque, int danioCompleto, int danioParcial, int danioNulo){
        this.nombreAtaque = nombreAtaque;
        this.danioCompleto = danioCompleto;
        this.danioParcial = danioParcial;
        this.danioNulo = danioNulo;
    }

    public Ataque(){

    }

    //TODO Getters & Setters

    public String getNombreAtaque() {
        return nombreAtaque;
    }

    public void setNombreAtaque(String nombreAtaque) {
        this.nombreAtaque = nombreAtaque;
    }

    public int getDanioCompleto() {
        return danioCompleto;
    }

    public void setDanioCompleto(int danioCompleto) {
        this.danioCompleto = danioCompleto;
    }

    public int getDanioParcial() {
        return danioParcial;
    }

    public void setDanioParcial(int danioParcial) {
        this.danioParcial = danioParcial;
    }

    public int getDanioNulo() {
        return danioNulo;
    }

    public void setDanioNulo(int danioNulo) {
        this.danioNulo = danioNulo;
    }

    //TODO Otros métodos

    public class DanioResultado {
    public int danio;
    public String tipo;

    public DanioResultado(int danio, String tipo) {
        this.danio = danio;
        this.tipo = tipo;
    }
}

    public DanioResultado obtenerDanioAleatorio() {
    Random random = new Random();
    int opcion = random.nextInt(3);

    switch (opcion) {
        case 0:
            return new DanioResultado(danioCompleto, "completo");
        case 1:
            return new DanioResultado(danioParcial, "parcial");
        default:
            return new DanioResultado(danioNulo, "nulo");
    }
}

}
