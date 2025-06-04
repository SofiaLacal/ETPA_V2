package modelo;

public class Enemigo {

    //TODO Atributos

    private String nombre;
    private int vida;

    //TODO Contructor

    public Enemigo (String nombre, int vida){
        this.nombre = nombre;
        this.vida = vida;
    }

    public Enemigo(){

    }

    //TODO Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    //TODO Otros métodos

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) vida = 0;

        System.out.println(nombre + " recibe " + cantidad + " de daño. Vida restante: " + vida);
    }

    public boolean estaVivo() {
    return vida > 0;
    }

}
