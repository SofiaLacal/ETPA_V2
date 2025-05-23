package modelo;

public abstract class Personaje {

    //TODO Atributos

    private String nombre;
    private int vida;
    private String [] inventario;
    private int [] finalesDisponibles;


    //TODO Contructor

    public Personaje (String nombre, int vida, String[] inventario, int[] finalesDisponibles){
        this.nombre = nombre;
        this.vida = vida;
        this.inventario = inventario;
        this.finalesDisponibles = finalesDisponibles;
    }

    public Personaje (){
        
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

    public String[] getInventario() {
        return inventario;
    }

    public void setInventario(String[] inventario) {
        this.inventario = inventario;
    }

    public int[] getFinalesDisponibles() {
        return finalesDisponibles;
    }

    public void setFinalesDisponibles(int[] finalesDisponibles) {
        this.finalesDisponibles = finalesDisponibles;
    }


    //TODO Métodos Abstractos

    public abstract void atacar(Personaje enemigo);
    public abstract void defender();
    public abstract void interactuarNPC();
    public abstract void recibirDanio(int cantidad);
    public abstract void curarse();
    
}