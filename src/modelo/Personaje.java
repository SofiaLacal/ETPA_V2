package modelo;

public class Personaje {

    //TODO Atributos

    private String nombre;
    private int vida;
    private int [] inventario;
    private Final[] finalesDisponibles = new Final[5];

    protected Ataque[] ataque = new Ataque[3];
    protected boolean estaDefendiendo = false;

    //TODO Constructor

    public Personaje (String nombre, int vida, int[] inventario){
        this.nombre = nombre;
        this.vida = vida;
        this.inventario = inventario;
        
        finalesDisponibles[0] = new Final("\nPor corazón puro y leal, te concederé mayor poder del que jamás podrías imaginar para la batalla que acontece"
        	+ "\nEntras en la cámara final, donde debían estar los soldados. Allí te espera Taharka, vestido con su armadura dorada, "
        	+ "en compañía de su fiel aliada Uraeus y con el Papiro de Damasco en la mano." 
        	+ "\nEstá a punto de liberar a las sombras para desatar el caos en todo Egipto y gobernar por encima de todos"
        	+ "\n\n############  FIN DEL JUEGO  ############");
          
        finalesDisponibles[1] = new Final("\nPor ser un avaricioso, sufrirás la ira de todos los dioses y tu alma será devorada en el Duat"
        	+ "\nHas muerto. Egipto se sume en un profundo caos."
        	+ "\nEl sol, alguna vez brillante y cálido sobre las tierras de Egipto, ahora está opacado por nubes oscuras que bloquean su luz."
        	+ "\nLas aguas del Nilo, fuente de vida para el imperio, se han vuelto turbias y peligrosas, arrastrando con ellas plagas que asolan los campos y aldeas."
        	+ "\n\n############  FIN DEL JUEGO  ############");
        
        finalesDisponibles[2] = new Final("\nFinal trágico: "
        	+ "\nEn una batalla épica, lograste vencer a Taharka, el usurpador oscuro."
        	+ "\nCon tu última fuerza, atravesaste su pecho, rompiendo el ciclo de terror que había sembrado sobre Egipto."
        	+ "\nPero tus heridas eran profundas y mientras el enemigo caía, tú también te desplomabas, exhalando tu último aliento con la certeza de que el pueblo viviría libre."
        	+ "\nMoriste como un héroe, pero Egipto llora tu caída."
        	+ "\n\n############  FIN DEL JUEGO  ############");
        
        finalesDisponibles[3] = new Final("\nFinal anónimo: "
        	+ "\nDerrotaste a Taharka en un combate silencioso entre las ruinas del templo prohibido. "
        	+ "\nEl mal fue erradicado, pero el mundo jamás supo cómo ni quién lo hizo. "
        	+ "\nTu figura se desvaneció entre las arenas del desierto, y otros tomaron el crédito por la salvación de Egipto. "
        	+ "\nFuiste testigo de un renacimiento que tú provocaste, aunque tu nombre se perdiera entre mitos y sombras. "
        	+ "\nLa historia te olvidó... pero el mundo te debe su libertad."
        	+ "\n\n############  FIN DEL JUEGO  ############");
        
        finalesDisponibles[4] = new Final("\nFinal heroico: "
        	+ "\nCon coraje inquebrantable, enfrentaste a Taharka en los pasillos del antiguo palacio. "
        	+ "\nTras una lucha titánica, lo venciste ante los ojos del pueblo y los dioses. El cielo se despejó, y Egipto volvió a respirar. "
        	+ "\nTe alzaron sobre los hombros, entonaron tu nombre en cada aldea y tallaron tu rostro en los muros de los templos. "
        	+ "\nComo héroe eterno, tu legado guiará a generaciones futuras. Eres el salvador de Egipto."
        	+ "\n\n############  FIN DEL JUEGO  ############");
    }

    //TODO Getters & Setters

    public Personaje(String nombre) {
    	this.nombre = nombre;
	}

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

    public Final[] getFinalesDisponibles() {
        return finalesDisponibles;
    }

    public void setFinalesDisponibles(Final[] finalesDisponibles) {
        this.finalesDisponibles = finalesDisponibles;
    }


    //TODO Otros Métodos

    public void mostrarNombrePersonaje() {
        System.out.println(nombre);
    }
    
    public void atacar(Enemigo enemigo, int indiceAtaque, int modificadorAtaque) {
        if (indiceAtaque < 0 || indiceAtaque >= ataque.length || ataque[indiceAtaque] == null) {
            System.out.println("Introduce un ataque válido");
            return;
        }

        Ataque ataqueElegido = ataque[indiceAtaque];
        DanioResultado resultado = ataqueElegido.obtenerDanioAleatorio();

        int danioFinal = resultado.danio + modificadorAtaque;
        if (danioFinal < 0) danioFinal = 0;

        enemigo.recibirDanio(danioFinal);
        System.out.println(nombre + " usa " + ataqueElegido.getNombreAtaque() + " (Modificador de Ataque: " + modificadorAtaque + "). Daño " + resultado.tipo + ".");
    }



    public void defender() {
        estaDefendiendo = true;
        System.out.println(nombre + " adopta una postura defensiva.");
    }

    
    /*public void interactuarNPC() {
        // Mas adelante
    }*/

    
    public void recibirDanio(int cantidad) {
    	
        if (estaDefendiendo) {
            cantidad /= 2;
            estaDefendiendo = false;
            System.out.println(nombre + " bloqueó parte del daño. Solo recibe " + cantidad + " de daño.");
       
        } else {

        }

        int nuevaVida = vida - cantidad;
        vida = Math.max(nuevaVida, 0);

        if (vida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public void curarse() {
        int cantidadCuracion = 50;
        vida += cantidadCuracion;
        System.out.println(nombre + " se cura " + cantidadCuracion + " puntos de vida con un botiquín. Vida actual: " + vida);
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
    
    
    public void activarFinal(int indice, Jugador jugador) {
        if (indice >= 0 && indice < finalesDisponibles.length && finalesDisponibles[indice] != null) {
            finalesDisponibles[indice].mostrarFinal();
        }
    }
    
    public void finalVida(Jugador jugador) {
        int indiceFinal;

        if (vida < 50) {
            indiceFinal = 2;
        } else if (vida < 100) {
            indiceFinal = 3;
        } else {
            indiceFinal = 4;
        }

        activarFinal(indiceFinal, jugador);
    }
}