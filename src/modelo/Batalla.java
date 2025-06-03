package modelo;

import java.util.Random;
import java.util.Scanner;

public class Batalla {

    private final Personaje personaje;
    private final Enemigo enemigo;
    private final Scanner scanner;

    public Batalla(Personaje personaje) {
        this.personaje = personaje;
        this.enemigo = elegirEnemigoAleatorio();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("\n¡Comienza el combate entre " + personaje.getNombre() + " y " + enemigo.getNombre() + "!");

        while (personaje.getVida() > 0 && enemigo.estaVivo()) {
            mostrarMenuJugador();
            if (enemigo.estaVivo()) {
                turnoEnemigo();
            }
        }

        if (personaje.getVida() <= 0) {
            System.out.println("\nHas sido derrotado. ¡Fin del juego!");
        } else {
            System.out.println("\n¡Has vencido a " + enemigo.getNombre() + "!");
        }
    }

private void mostrarMenuJugador() {
    int accion = 0;

    while (accion < 1 || accion > 3) {
        System.out.println("\n--- Turno de " + personaje.getNombre() + " ---");
        System.out.println("Vida actual: " + personaje.getVida());
        System.out.println("\n¿Qué deseas hacer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Curarse\n");
        System.out.print("Opción: ");

        accion = scanner.nextInt();
        scanner.nextLine();

        switch (accion) {
            case 1:
                String[] nombresAtaques = personaje.getNombresDeAtaques();
                System.out.println("Elige un ataque:");
                for (int i = 0; i < nombresAtaques.length; i++) {
                    System.out.println((i + 1) + ". " + nombresAtaques[i]);
                }
                System.out.print("Opción: ");
                int indiceAtaque = scanner.nextInt() - 1;
                scanner.nextLine();
                personaje.atacar(enemigo, indiceAtaque);
                break;

            case 2:
                personaje.defender();
                break;

            case 3:
                personaje.curarse();
                break;

            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                accion = 0;
                break;
        }
    }
}


    private void turnoEnemigo() {
        int danioEnemigo = 30;
        System.out.println("\n--- Turno del enemigo ---");
        System.out.println(enemigo.getNombre() + " ataca y causa " + danioEnemigo + " de daño.");
        personaje.recibirDanio(danioEnemigo);
    }

    private Enemigo elegirEnemigoAleatorio() {
        Enemigo[] enemigos = new Enemigo[] {
                new Enemigo("Gusano del Desierto", 100),
                new Enemigo("Escorpión de Piedra", 120),
                new Enemigo("Momia Guerrera", 150),
                new Enemigo("Espectro de Arena", 130),
                new Enemigo("Sombra Faraónica", 160)
        };

        Random random = new Random();
        int indice = random.nextInt(enemigos.length);
        return enemigos[indice];
    }
}
