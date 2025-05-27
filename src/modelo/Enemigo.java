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

    //TODO Enemigos

    public static final Enemigo GUSANO = new Enemigo("Gusano del Desierto", 100);
    public static final Enemigo ESPECTRO = new Enemigo("Espectro de Arena", 120);
    public static final Enemigo GUARDIAN = new Enemigo("Guardián de Obsidiana", 150);
    public static final Enemigo SERPIENTE = new Enemigo("Serpiente Solar", 130);
    public static final Enemigo SOMBRA = new Enemigo("Sombra Faraónica", 180);

}
