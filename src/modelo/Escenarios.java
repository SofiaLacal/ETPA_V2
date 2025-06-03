package modelo;

public class Escenarios {
    
    private String nombreEscenario;

    private enum estadoEscenario{

        VENTILADO(0.0),
        HUMEDO(0.1),
        POLVORIENTO(0.1),
        COLAPSADO(0.2);

        private double menosAtaque;

        private estadoEscenario(double menosAtaque) {
            this.menosAtaque = menosAtaque;
        }

        private double getMenosAtaque() {
            return menosAtaque;
        }

    }

    private enum horaEscenario{

        DIA(0.0, 0.0),
        TARDE(0.0, 0.0),
        NOCHE(0.1, -0.2);

        private double menosDefensa;
        private double masAtaque;

        private horaEscenario(double menosDefensa, double masAtaque) {
            this.menosDefensa = menosDefensa;
            this.masAtaque = masAtaque;
        }

    }

    private enum terrenoEscenario{

    }
}
