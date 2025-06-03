package personajes;

import modelo.Ataque;
import modelo.Personaje;

public class Bastet extends Personaje {

    public Bastet() {
        super("Bastet", 700, new int[3], new int[5]);
        getInventario()[0] = 2;
        ataque[0] = new Ataque("Básico", 30, 15, 0);
        ataque[1] = new Ataque("Flor Fatal", 70, 35, 0);
        ataque[2] = new Ataque("Alma Voraz", 40, 20, 0);
    }
}
