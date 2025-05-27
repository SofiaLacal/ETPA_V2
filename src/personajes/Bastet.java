package personajes;

import modelo.Ataque;
import modelo.Enemigo;
import modelo.Personaje;

public class Bastet extends Personaje {

private Ataque[] ataque = new Ataque[3];
private boolean estaDefendiendo = false;

    public Bastet() {
        super("Bastet", 700, new String[0], new int[5]);
        ataque[0] = new Ataque("Básico", 30, 15, 0);
        ataque[1] = new Ataque("Flor Fatal", 70, 35, 0);
        ataque[2] = new Ataque("Alma Voraz", 40, 20, 0);
    }

    public void atacar(Enemigo enemigo, int indiceAtaque) {
        if (indiceAtaque < 0 || indiceAtaque >= ataque.length || ataque[indiceAtaque] == null) {
            System.out.println("Introduce un ataque valido");
            return;
        }

        Ataque ataqueElegido = ataque[indiceAtaque];
        enemigo.recibirDanio(ataqueElegido.getDanioCompleto());
        System.out.println(getNombre() + " usa " + ataqueElegido.getNombreAtaque() + " y causa " + ataqueElegido.getDanioCompleto() + " de daño.");
    }

    public void defender(){
        estaDefendiendo = true;
        System.out.println(getNombre() + " adopta una postura defensiva.");
    }

    public void interactuarNPC(){
        //Pa mas tarde
    }

    public void recibirDanio(int cantidad){
        if (estaDefendiendo) {

        cantidad /= 2;
        estaDefendiendo = false;

        System.out.println(getNombre() + " bloqueó parte del daño. Solo recibe " + cantidad + " de daño.");
        } else {
        System.out.println(getNombre() + " recibe " + cantidad + " de daño.");
        }

    int nuevaVida = getVida() - cantidad;
    setVida(Math.max(nuevaVida, 0));

        if (getVida() <= 0) {
            System.out.println(getNombre() + " ha sido derrotado.");
        }
    }

    public void curarse(){
    int cantidadCuracion = 25;
    int nuevaVida = getVida() + cantidadCuracion;
    setVida(nuevaVida);
    System.out.println(getNombre() + " se cura " + cantidadCuracion + " puntos de vida. Vida actual: " + getVida());
    }

    public String[] getNombresDeAtaques() {
    String[] nombres = new String[ataque.length];
    for (int i = 0; i < ataque.length; i++) {
        nombres[i] = ataque[i].getNombreAtaque();
    }
    return nombres;
    }
    
}
