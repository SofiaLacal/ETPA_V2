package modelo;

import java.util.Random;

public class Escenarios {

    private static Escenarios instancia; // Singleton

    private EstadoEscenario estado;
    private HoraEscenario hora;

    public enum EstadoEscenario {
        NADA(0),
        HUMEDO(10),
        POLVORIENTO(10),
        NIEBLA(20);

        private final int menosAtaque;

        EstadoEscenario(int menosAtaque) {
            this.menosAtaque = menosAtaque;
        }

        public int getMenosAtaque() {
            return menosAtaque;
        }
    }

    public enum HoraEscenario {
        DIA(0, 0),
        TARDE(0, 0),
        NOCHE(10, 20);

        private final int menosDefensa;
        private final int masAtaque;

        HoraEscenario(int menosDefensa, int masAtaque) {
            this.menosDefensa = menosDefensa;
            this.masAtaque = masAtaque;
        }

        public int getMenosDefensa() {
            return menosDefensa;
        }

        public int getMasAtaque() {
            return masAtaque;
        }
    }

    private Escenarios() {
        this.estado = getEstadoAleatorio();
        this.hora = getHoraAleatoria();

        imprimirCondiciones();
        System.out.println("Modificador Ataque inicial: " + getModificadorAtaque());
        System.out.println("Modificador Defensa inicial: " + getModificadorDefensa());
        System.out.println("---------------------------------");
    }

    public static Escenarios getInstancia() {
        if (instancia == null) {
            instancia = new Escenarios();
        }
        return instancia;
    }

    private EstadoEscenario getEstadoAleatorio() {
        EstadoEscenario[] estados = EstadoEscenario.values();
        return estados[new Random().nextInt(estados.length)];
    }

    private HoraEscenario getHoraAleatoria() {
        HoraEscenario[] horas = HoraEscenario.values();
        return horas[new Random().nextInt(horas.length)];
    }

    public int getModificadorAtaque() {
        int modificador = hora.getMasAtaque() - estado.getMenosAtaque();
        // Para evitar modificador negativo, descomenta la siguiente línea:
        // modificador = Math.max(0, modificador);
        return modificador;
    }

    public int getModificadorDefensa() {
        int modificador = -hora.getMenosDefensa();
        // Si quieres que la defensa no sea negativa, usa:
        // modificador = Math.max(0, modificador);
        return modificador;
    }

    public void imprimirCondiciones() {
        System.out.println("\n---------------------------------");
        System.out.println("Condición ambiental: " + estado.name());
        System.out.println("Hora del día: " + hora.name());
    }
}
