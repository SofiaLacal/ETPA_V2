package modelo;

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

}
