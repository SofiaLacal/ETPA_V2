package modelo;

public class Personaje {

    //TODO Atributos

    private String nombre;
    private int vida;
    private int [] inventario;
    private int [] finalesDisponibles;

    protected Ataque[] ataque = new Ataque[3];
    protected boolean estaDefendiendo = false;

    //TODO Contructor

    public Personaje (String nombre, int vida, int[] inventario, int[] finalesDisponibles){
        this.nombre = nombre;
        this.vida = vida;
        this.inventario = inventario;
        this.finalesDisponibles = finalesDisponibles;
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

    public int[] getInventario() {
        return inventario;
    }

    public void setInventario(int[] inventario) {
        this.inventario = inventario;
    }

    public int[] getFinalesDisponibles() {
        return finalesDisponibles;
    }

    public void setFinalesDisponibles(int[] finalesDisponibles) {
        this.finalesDisponibles = finalesDisponibles;
    }


    //TODO Otros Métodos

    public void atacar(Enemigo enemigo, int indiceAtaque) {
        if (indiceAtaque < 0 || indiceAtaque >= ataque.length || ataque[indiceAtaque] == null) {
            System.out.println("Introduce un ataque válido");
            return;
        }

        Ataque ataqueElegido = ataque[indiceAtaque];
        enemigo.recibirDanio(ataqueElegido.getDanioCompleto());
        System.out.println(nombre + " usa " + ataqueElegido.getNombreAtaque() +
                           " y causa " + ataqueElegido.getDanioCompleto() + " de daño.");
    }

    public void defender() {
        estaDefendiendo = true;
        System.out.println(nombre + " adopta una postura defensiva.");
    }

    public void interactuarNPC() {
        // Mas adelante
    }

    public void recibirDanio(int cantidad) {
        if (estaDefendiendo) {
            cantidad /= 2;
            estaDefendiendo = false;
            System.out.println(nombre + " bloqueó parte del daño. Solo recibe " + cantidad + " de daño.");
        } else {
            System.out.println(nombre + " recibe " + cantidad + " de daño.");
        }

        int nuevaVida = vida - cantidad;
        vida = Math.max(nuevaVida, 0);

        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public void curarse() {
        int cantidadCuracion = 25;
        vida += cantidadCuracion;
        System.out.println(nombre + " se cura " + cantidadCuracion +
                           " puntos de vida con un botiquín. Vida actual: " + vida);
    }

    public void usarBotiquin() {
        if (inventario[0] > 0) {
            curarse();
            inventario[0]--;
        } else {
            System.out.println(nombre + " no tiene botiquines.");
        }
    }

    public String[] getNombresDeAtaques() {
        String[] nombres = new String[ataque.length];
        for (int i = 0; i < ataque.length; i++) {
            nombres[i] = ataque[i].getNombreAtaque();
        }
        return nombres;
    }



    
}