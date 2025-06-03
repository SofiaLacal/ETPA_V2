package modelo;

import java.util.Random;
import java.util.Scanner;

import controlador.Menu;

public class Rompecabezas {

    // Metodos
    public void IniciarJuegos(Rompecabezas rompecabezas) {
       
        Rompecabezas rompe = new Rompecabezas();
         
        System.out.println("Os encontráis con el primer rompecabezas en vuestro camino, a las puertas de la Pirámide de Ezhar." 
		+ "Encima de la puerta se lee lo siguiente: ");
		System.out.println("\nSoy eterno, pero nunca envejezco. Mi rostro es de piedra, pero nunca me canso. ");
		System.out.println("Vigilante del sol y del desierto sin fin, en el misterio de las pirámides guardo mi sin fin. ¿Qué soy?");

       rompe.adivinanzaUno();
        
        System.out.println("\nEntráis a la pirámide y os encontráis con la esfinge guardiana de la pirámide.");
        System.out.println("\nOs doy la bienvenida guerreros, pero no puedo dejar que os adentréis en la cámara sin saber si sois dignos.");
        System.out.println("Lo sabré con vuestra respuesta. Tenéis 5 intentos.");
        System.out.println("\n''Para en la cámara poder entrar el número debéis acertar''");

        rompe.adivinanzaDos();

        System.out.println("La esfinge os deja paso a la cámara.");
        System.out.println("Allí os encontráis a un guardián, que os dice que está muy solo y os pide compañía. Os propone jugar con él a piedra, papel o tijera.");
        System.out.println("\nSi ganáis de manera justa, os permitirá continuar. El juego será al mejor de tres.");

        rompe.PPT();

        rompe.trivial();

        rompe.ahorcado();

    }

    //Adivinar Efinge

    private void adivinanzaUno(){

            Scanner sc = new Scanner(System.in);

            String respuestaUsuario = sc.nextLine();
            int intentosR = 5;
            int puntuacion;

			while (!respuestaUsuario.equalsIgnoreCase("Esfinge") && !respuestaUsuario.equalsIgnoreCase("La esfinge") && intentosR != 1) {
				            System.out.println (respuestaUsuario + " no es correcto, intentalo de nuevo.");
				            intentosR--;
				            System.out.println("Te quedan " +intentosR+ " intentos restantes.");
				            respuestaUsuario = sc.nextLine();
			}
				        
				if (respuestaUsuario.equalsIgnoreCase("Esfinge") || respuestaUsuario.equalsIgnoreCase("La esfinge")) {
				            System.out.println("¡Es correcto! La puerta se abre ante vosotros");
				            puntuacion = 20;
					
				} else {
						System.out.println("Has gastado todos tus intentos.");
				}

    }

    // Adivina el número
    private void adivinanzaDos(){
        
        Random random = new Random ();
        Scanner sc = new Scanner(System.in);
        
        int numeroAdivinar = random.nextInt(10);
        int adivina = 0;
        int intentosR = 3;
        int puntuacion = 0;

        while (numeroAdivinar != adivina && intentosR != 0) {
				adivina = sc.nextInt();      
					while (adivina <= 0 || adivina >= 10) {
						System.out.println("Prueba otra vez");
						adivina = sc.nextInt();
					}
						
					if (adivina > numeroAdivinar) {
						System.out.println("Más bajo");
						intentosR--;
						System.out.println("Te quedan " + intentosR +" intentos.");
						System.out.println("");
					}
						            
					if (adivina < numeroAdivinar) {
						System.out.println("Más alto");
						intentosR--;
						System.out.println("Te quedan " + intentosR +" intentos.");
						System.out.println("");
					}    
				}
				
				if (intentosR > 0) { 
					System.out.println(" ");
					System.out.println("Adelante, podéis pasar. " + numeroAdivinar + " era el número correcto.");
					System.out.println("  ");
					puntuacion = 20;
					
				} else {
					System.out.println("Habeis gastado todos los intentos.");
					System.out.println("Os permitiré la entrada, pero a cambio, al haber fallado la prueba te quedas sin un uso de tu ataque especial.");
				}
    }


    // Piedra, Papel o Tijera
    private void PPT(){
       
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] opciones = {"Piedra", "Papel", "Tijera"};

        int eleccionOponente = random.nextInt(3);
		boolean juegoActivo = true;
		int intentosR = 3;
		int puntosEnemigo = 0;
	    int puntosUsuario = 0;
        String personaje = "getPersonaje()";
        int eleccionJugador;
        int puntuacion;


        while (puntosEnemigo != 3 && puntosUsuario != 3) {
				eleccionOponente = random.nextInt(3);
				System.out.println("Piedra, papel o tijera.... 1, 2, 3!");
				System.out.println("0: Piedra, 1: Papel, 2: Tijera");
				System.out.println("Tu elección");
				eleccionJugador = sc.nextInt();
						
				while (eleccionJugador < 0 || eleccionJugador > 2) {
							System.out.println("Esa no es una opción válida.");
							eleccionJugador = sc.nextInt();
				}
						
				System.out.println("");
			    System.out.println("Tu elección: " + opciones[eleccionJugador]);
			    System.out.println("Elección del guardián: " + opciones[eleccionOponente]);
						
			    if (eleccionJugador == eleccionOponente) {
				    System.out.println("¡Es un empate!");
				    System.out.println("  ");
			            
			    } else if ((eleccionJugador == 0 && eleccionOponente == 2) || 
			    		   (eleccionJugador == 1 && eleccionOponente == 0) || 
			    		   (eleccionJugador == 2 && eleccionOponente == 1)) {
			    	System.out.println("  ");
			        System.out.println("¡Has ganado!");
			        puntosUsuario++;
			        System.out.println("  ");
			        System.out.println("Puntuación: ");
			        System.out.println(personaje + " tienes: " + puntosUsuario + " puntos");
			        System.out.println("El guardián tiene: " + puntosEnemigo + " puntos");
			           	
			    } else {
			        System.out.println(" ");
			        System.out.println("¡Has perdido!");
			        puntosEnemigo++;
			        System.out.println(" ");
			        System.out.println("Puntuación: ");
			        System.out.println(personaje + " tienes: " + puntosUsuario + " puntos");
			        System.out.println("El guardián tiene: " + puntosEnemigo + " puntos");
			    }
			}
					
			if (puntosUsuario == 3) {
				System.out.println(" ");
				System.out.println("Me has derrotado justamente, podéis continuar vuestro camino.");
				puntuacion = 20;
				System.out.println("  ");
				System.out.println(personaje + " y sus 3 aliados continúan su camino");
						
			} else {
				System.out.println(" ");
				System.out.println("Habeis perdido la prueba, podéis pasar a la siguiente zona, pero a cambio de un uso de tu ataque especial " + personaje);
			}
					
			System.out.println("Los héroes pasan a la segunda cámara");
			System.out.println(" ");
			System.out.println("Para vuestra sorpresa en la cámara se encuentra Bennu, que os pone otra prueba.");
			System.out.println("Se trata de un trivial sobre Egipto");
			System.out.println(" ");
        }

    // Ahorcado
    
    private void ahorcado(){

        Scanner sc = new Scanner(System.in);

        String[] palabras = {"Seth", "Anubis", "Horus", "Osiris", "Sekhmet"};
		String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];
		int longitud = palabraSecreta.length();
		char [] letrasAdivinadas = new char[longitud];

        int intentosRestantes = 6; 
	    boolean palabraAdivinada = false;
	    boolean letraEncontrada = false;
	    String entrada;
        int puntuacion;

        for (int i = 0; i < longitud; i++) {
				letrasAdivinadas[i] = '-';  
			}
				        
			while (intentosRestantes > 0 && !palabraAdivinada) {
			System.out.println("Palabra: " + new String(letrasAdivinadas));
			System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
			System.out.print("Introduce una letra o la palabra completa si la tienes: ");
			entrada = sc.nextLine(); 
				        
				if (entrada.length() == 1) {
					char letra = entrada.charAt(0);
			                      
					for (int i = 0; i < longitud; i++) {
					            	
						 if (palabraSecreta.charAt(i) == letra) {
							 letrasAdivinadas[i] = letra;
							 letraEncontrada = true;
						 }
					 }
				            		            
						 if (!letraEncontrada) {
						 intentosRestantes--;
						 System.out.println("¡Letra incorrecta!");
						                
						 } else {
						 System.out.println("Esa letra está en la palabra");
						 }
				            	
				} else if (entrada.length() == longitud) {
			                
				         if (entrada.equalsIgnoreCase(palabraSecreta)) {
					         letrasAdivinadas = palabraSecreta.toCharArray(); 
					         System.out.println(" ");
					         System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
					         palabraAdivinada = true;
				                    
				         } else {
					         intentosRestantes--;
					         System.out.println(" ");
					         System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
				         }
				                
				} else {
					System.out.println("Entrada no válida. Debes introducir una letra o la palabra completa.");
				}
				        
				palabraAdivinada = true;
				
				for (char c : letrasAdivinadas) {
				                
					if (c == '-') {
						palabraAdivinada = false;
						continue;
					}
				}
			}      
				        
				if (!palabraAdivinada) {
					System.out.println(" ");
					System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
					System.out.println("");
					
				} else {
					System.out.println(" ");
					System.out.println("Has superado la prueba de Imhotep. Se aparta para dejaros paso.");
					System.out.println(" ");
					puntuacion = 20;
				}
    }

    // Trivial
    private void trivial (){

        Scanner sc = new Scanner(System.in);
        int puntuacionTrivial = 0;
	    String respuesta1 = "";
	    String respuesta2 = "";
	    String respuesta3 = "";
	    String respuesta4 = "";
        int puntuacion;
        String personaje = "getPersonaje()";

        // Pregunta 1
			System.out.println("Pregunta 1: ¿Cuál es el río más largo de Egipto?");
			System.out.println("a) Amazonas");
			System.out.println("b) Nilo");
			System.out.println("c) Yangtsé");
			System.out.println("d) Misisipi");
			respuesta1 = sc.nextLine().toLowerCase();
				       
			while (!respuesta1.equals("a") && !respuesta1.equals("b") && !respuesta1.equals("c") && !respuesta1.equals("d")) {
				respuesta1 = sc.nextLine().toLowerCase();
			}
				       
				if (respuesta1.equals("b")) {
					puntuacionTrivial++;
					System.out.println("¡Correcto!");
					System.out.println("");
				            
				} else {
					System.out.println("No has acertado, la respuesta correcta es: el Nilo.");
					System.out.println(" ");
				}

			// Pregunta 2
			System.out.println("Pregunta 2: ¿Quién fue el faraón más joven de Egipto?");
			System.out.println("a) Ramsés II");
			System.out.println("b) Tutankamón");
			System.out.println("c) Cleopatra");
			System.out.println("d) Akhenatón");
			respuesta2 = sc.nextLine().toLowerCase();
				        
			while (!respuesta2.equals("a") && !respuesta2.equals("b") && !respuesta2.equals("c") && !respuesta2.equals("d")) {
					System.out.println("Esa no es la respuesta. Tienes otro intento");
					respuesta2 = sc.nextLine().toLowerCase();
			}
					    
				if (respuesta2.equals("b")) {
			        puntuacionTrivial++;
			        System.out.println("¡Correcto!");
			        System.out.println("");
			        
			    } else {
			        System.out.println("No has acertado, la respuesta correcta es: Tutankamón.");
			        System.out.println("");
			    }

			// Pregunta 3
			System.out.println("Pregunta 3: ¿Qué estructura famosa se encuentra en Giza?");
			System.out.println("a) La Gran Muralla");
			System.out.println("b) El Coliseo");
			System.out.println("c) La Torre Eiffel");
			System.out.println("d) Las Pirámides");
			respuesta3 = sc.nextLine().toLowerCase();
				        
			while (!respuesta3.equals("a") && !respuesta3.equals("b") && !respuesta3.equals("c") && !respuesta3.equals("d")) {
					System.out.println("Esa no es la respuesta. Tienes otro intento");
					respuesta3 = sc.nextLine().toLowerCase();
			}
					    
				if (respuesta3.equals("d")) {
					puntuacionTrivial++;
			        System.out.println("¡Correcto!");
			        System.out.println("");
			            
			    } else {
			        System.out.println("No has acertado, la respuesta correcta es: las Pirámides.");
			        System.out.println("");
			    }

			// Pregunta 4
			System.out.println("Pregunta 4: ¿Qué animal se representa en la Esfinge de Giza?");
			System.out.println("a) León");
			System.out.println("b) Águila");
			System.out.println("c) Serpiente");
			System.out.println("d) Gato");
			respuesta4 = sc.nextLine().toLowerCase();
				        
			while (!respuesta4.equals("a") && !respuesta4.equals("b") && !respuesta4.equals("c") && !respuesta4.equals("d")) {
					System.out.println("Esa no es la respuesta. Tienes otro intento");
					respuesta4 = sc.nextLine().toLowerCase();
			}	   
					    
				if (respuesta4.equals("a")) {
					puntuacionTrivial++;
			        System.out.println("¡Correcto!");
			        System.out.println("");
			          
				} else {
			        System.out.println("No has acertado, la respuesta correcta es: el león.");
			        System.out.println("");
			    }
				  
			System.out.println("Has terminado el rompecabezas. Tu puntuación es: " + puntuacionTrivial + "/4");
				        
		    if (puntuacionTrivial == 4) {
		    	System.out.println("¡Felicidades! Has ganado el rompecabezas del Antiguo Egipto.");
				puntuacion = 20;
				System.out.println("");
				            
			} else {
				System.out.println("No habéis acertado todas las respuestas, como castigo te retiro un uso de tu ataque especial " + personaje);
				System.out.println("");
			}
				       
			System.out.println("Pasáis a la siguiente cámara, donde os encontráis con Imhotep, sabio sacerdote del Antigüo Egipto, guardián de las almas.");
			System.out.println("''¿Os atrevéis a adentraros en las entrañas del conocimiento prohibido?''");
			System.out.println("Para poder superar esta prueba, tenéis que acertar la palabra secreta. Si falláis, el alma de uno de vosotros quedará atrapada aquí."); 
			System.out.println("PISTA: Seth, Anubis, Horus, Osiris, Sekhmet");
			System.out.println(" ");
    }
}

    //TODO Atributos

       rompe.adivinanzaUno();
        
        System.out.println("\nEntráis a la pirámide y os encontráis con la esfinge guardiana de la pirámide.");
        System.out.println("\nOs doy la bienvenida guerreros, pero no puedo dejar que os adentréis en la cámara sin saber si sois dignos.");
        System.out.println("Lo sabré con vuestra respuesta. Tenéis 5 intentos.");
        System.out.println("\n''Para en la cámara poder entrar el número debéis acertar''");

        rompe.adivinanzaDos();

        System.out.println("La esfinge os deja paso a la cámara.");
        System.out.println("Allí os encontráis a un guardián, que os dice que está muy solo y os pide compañía. Os propone jugar con él a piedra, papel o tijera.");
        System.out.println("\nSi ganáis de manera justa, os permitirá continuar. El juego será al mejor de tres.");

        rompe.PPT();

        rompe.trivial();

        rompe.ahorcado();

    }

    //Adivinar Efinge

    private void adivinanzaUno(){

            Scanner sc = new Scanner(System.in);

            String respuestaUsuario = sc.nextLine();
            int intentosR = 5;
            int puntuacion;

			while (!respuestaUsuario.equalsIgnoreCase("Esfinge") && !respuestaUsuario.equalsIgnoreCase("La esfinge") && intentosR != 1) {
				            System.out.println (respuestaUsuario + " no es correcto, intentalo de nuevo.");
				            intentosR--;
				            System.out.println("Te quedan " +intentosR+ " intentos restantes.");
				            respuestaUsuario = sc.nextLine();
			}
				        
				if (respuestaUsuario.equalsIgnoreCase("Esfinge") || respuestaUsuario.equalsIgnoreCase("La esfinge")) {
				            System.out.println("¡Es correcto! La puerta se abre ante vosotros");
				            puntuacion = 20;
					
				} else {
						System.out.println("Has gastado todos tus intentos.");
				}

    }

    // Adivina el número
    private void adivinanzaDos(){
        
        Random random = new Random ();
        Scanner sc = new Scanner(System.in);
        
        int numeroAdivinar = random.nextInt(10);
        int adivina = 0;
        int intentosR = 3;
        int puntuacion = 0;

        while (numeroAdivinar != adivina && intentosR != 0) {
				adivina = sc.nextInt();      
					while (adivina <= 0 || adivina >= 10) {
						System.out.println("Prueba otra vez");
						adivina = sc.nextInt();
					}
						
					if (adivina > numeroAdivinar) {
						System.out.println("Más bajo");
						intentosR--;
						System.out.println("Te quedan " + intentosR +" intentos.");
						System.out.println("");
					}
						            
					if (adivina < numeroAdivinar) {
						System.out.println("Más alto");
						intentosR--;
						System.out.println("Te quedan " + intentosR +" intentos.");
						System.out.println("");
					}    
				}
				
				if (intentosR > 0) { 
					System.out.println(" ");
					System.out.println("Adelante, podéis pasar. " + numeroAdivinar + " era el número correcto.");
					System.out.println("  ");
					puntuacion = 20;
					
				} else {
					System.out.println("Habeis gastado todos los intentos.");
					System.out.println("Os permitiré la entrada, pero a cambio, al haber fallado la prueba te quedas sin un uso de tu ataque especial.");
				}
    }


    // Piedra, Papel o Tijera
    private void PPT(){
       
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] opciones = {"Piedra", "Papel", "Tijera"};

        int eleccionOponente = random.nextInt(3);
		boolean juegoActivo = true;
		int intentosR = 3;
		int puntosEnemigo = 0;
	    int puntosUsuario = 0;
        String personaje = "getPersonaje()";
        int eleccionJugador;
        int puntuacion;


        while (puntosEnemigo != 3 && puntosUsuario != 3) {
				eleccionOponente = random.nextInt(3);
				System.out.println("Piedra, papel o tijera.... 1, 2, 3!");
				System.out.println("0: Piedra, 1: Papel, 2: Tijera");
				System.out.println("Tu elección");
				eleccionJugador = sc.nextInt();
						
				while (eleccionJugador < 0 || eleccionJugador > 2) {
							System.out.println("Esa no es una opción válida.");
							eleccionJugador = sc.nextInt();
				}
						
				System.out.println("");
			    System.out.println("Tu elección: " + opciones[eleccionJugador]);
			    System.out.println("Elección del guardián: " + opciones[eleccionOponente]);
						
			    if (eleccionJugador == eleccionOponente) {
				    System.out.println("¡Es un empate!");
				    System.out.println("  ");
			            
			    } else if ((eleccionJugador == 0 && eleccionOponente == 2) || 
			    		   (eleccionJugador == 1 && eleccionOponente == 0) || 
			    		   (eleccionJugador == 2 && eleccionOponente == 1)) {
			    	System.out.println("  ");
			        System.out.println("¡Has ganado!");
			        puntosUsuario++;
			        System.out.println("  ");
			        System.out.println("Puntuación: ");
			        System.out.println(personaje + " tienes: " + puntosUsuario + " puntos");
			        System.out.println("El guardián tiene: " + puntosEnemigo + " puntos");
			           	
			    } else {
			        System.out.println(" ");
			        System.out.println("¡Has perdido!");
			        puntosEnemigo++;
			        System.out.println(" ");
			        System.out.println("Puntuación: ");
			        System.out.println(personaje + " tienes: " + puntosUsuario + " puntos");
			        System.out.println("El guardián tiene: " + puntosEnemigo + " puntos");
			    }
			}
					
			if (puntosUsuario == 3) {
				System.out.println(" ");
				System.out.println("Me has derrotado justamente, podéis continuar vuestro camino.");
				puntuacion = 20;
				System.out.println("  ");
				System.out.println(personaje + " y sus 3 aliados continúan su camino");
						
			} else {
				System.out.println(" ");
				System.out.println("Habeis perdido la prueba, podéis pasar a la siguiente zona, pero a cambio de un uso de tu ataque especial " + personaje);
			}
					
			System.out.println("Los héroes pasan a la segunda cámara");
			System.out.println(" ");
			System.out.println("Para vuestra sorpresa en la cámara se encuentra Bennu, que os pone otra prueba.");
			System.out.println("Se trata de un trivial sobre Egipto");
			System.out.println(" ");
        }

    // Ahorcado
    
    private void ahorcado(){

        Scanner sc = new Scanner(System.in);

        String[] palabras = {"Seth", "Anubis", "Horus", "Osiris", "Sekhmet"};
		String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];
		int longitud = palabraSecreta.length();
		char [] letrasAdivinadas = new char[longitud];

        int intentosRestantes = 6; 
	    boolean palabraAdivinada = false;
	    boolean letraEncontrada = false;
	    String entrada;
        int puntuacion;

        for (int i = 0; i < longitud; i++) {
				letrasAdivinadas[i] = '-';  
			}
				        
			while (intentosRestantes > 0 && !palabraAdivinada) {
			System.out.println("Palabra: " + new String(letrasAdivinadas));
			System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
			System.out.print("Introduce una letra o la palabra completa si la tienes: ");
			entrada = sc.nextLine(); 
				        
				if (entrada.length() == 1) {
					char letra = entrada.charAt(0);
			                      
					for (int i = 0; i < longitud; i++) {
					            	
						 if (palabraSecreta.charAt(i) == letra) {
							 letrasAdivinadas[i] = letra;
							 letraEncontrada = true;
						 }
					 }
				            		            
						 if (!letraEncontrada) {
						 intentosRestantes--;
						 System.out.println("¡Letra incorrecta!");
						                
						 } else {
						 System.out.println("Esa letra está en la palabra");
						 }
				            	
				} else if (entrada.length() == longitud) {
			                
				         if (entrada.equalsIgnoreCase(palabraSecreta)) {
					         letrasAdivinadas = palabraSecreta.toCharArray(); 
					         System.out.println(" ");
					         System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
					         palabraAdivinada = true;
				                    
				         } else {
					         intentosRestantes--;
					         System.out.println(" ");
					         System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
				         }
				                
				} else {
					System.out.println("Entrada no válida. Debes introducir una letra o la palabra completa.");
				}
				        
				palabraAdivinada = true;
				
				for (char c : letrasAdivinadas) {
				                
					if (c == '-') {
						palabraAdivinada = false;
						continue;
					}
				}
			}      
				        
				if (!palabraAdivinada) {
					System.out.println(" ");
					System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
					System.out.println("");
					
				} else {
					System.out.println(" ");
					System.out.println("Has superado la prueba de Imhotep. Se aparta para dejaros paso.");
					System.out.println(" ");
					puntuacion = 20;
				}
    }

    // Trivial
    private void trivial (){

        Scanner sc = new Scanner(System.in);
        int puntuacionTrivial = 0;
	    String respuesta1 = "";
	    String respuesta2 = "";
	    String respuesta3 = "";
	    String respuesta4 = "";
        int puntuacion;
        String personaje = "getPersonaje()";

        // Pregunta 1
			System.out.println("Pregunta 1: ¿Cuál es el río más largo de Egipto?");
			System.out.println("a) Amazonas");
			System.out.println("b) Nilo");
			System.out.println("c) Yangtsé");
			System.out.println("d) Misisipi");
			respuesta1 = sc.nextLine().toLowerCase();
				       
			while (!respuesta1.equals("a") && !respuesta1.equals("b") && !respuesta1.equals("c") && !respuesta1.equals("d")) {
				respuesta1 = sc.nextLine().toLowerCase();
			}
				       
				if (respuesta1.equals("b")) {
					puntuacionTrivial++;
					System.out.println("¡Correcto!");
					System.out.println("");
				            
				} else {
					System.out.println("No has acertado, la respuesta correcta es: el Nilo.");
					System.out.println(" ");
				}

			// Pregunta 2
			System.out.println("Pregunta 2: ¿Quién fue el faraón más joven de Egipto?");
			System.out.println("a) Ramsés II");
			System.out.println("b) Tutankamón");
			System.out.println("c) Cleopatra");
			System.out.println("d) Akhenatón");
			respuesta2 = sc.nextLine().toLowerCase();
				        
			while (!respuesta2.equals("a") && !respuesta2.equals("b") && !respuesta2.equals("c") && !respuesta2.equals("d")) {
					System.out.println("Esa no es la respuesta. Tienes otro intento");
					respuesta2 = sc.nextLine().toLowerCase();
			}
					    
				if (respuesta2.equals("b")) {
			        puntuacionTrivial++;
			        System.out.println("¡Correcto!");
			        System.out.println("");
			        
			    } else {
			        System.out.println("No has acertado, la respuesta correcta es: Tutankamón.");
			        System.out.println("");
			    }

			// Pregunta 3
			System.out.println("Pregunta 3: ¿Qué estructura famosa se encuentra en Giza?");
			System.out.println("a) La Gran Muralla");
			System.out.println("b) El Coliseo");
			System.out.println("c) La Torre Eiffel");
			System.out.println("d) Las Pirámides");
			respuesta3 = sc.nextLine().toLowerCase();
				        
			while (!respuesta3.equals("a") && !respuesta3.equals("b") && !respuesta3.equals("c") && !respuesta3.equals("d")) {
					System.out.println("Esa no es la respuesta. Tienes otro intento");
					respuesta3 = sc.nextLine().toLowerCase();
			}
					    
				if (respuesta3.equals("d")) {
					puntuacionTrivial++;
			        System.out.println("¡Correcto!");
			        System.out.println("");
			            
			    } else {
			        System.out.println("No has acertado, la respuesta correcta es: las Pirámides.");
			        System.out.println("");
			    }

			// Pregunta 4
			System.out.println("Pregunta 4: ¿Qué animal se representa en la Esfinge de Giza?");
			System.out.println("a) León");
			System.out.println("b) Águila");
			System.out.println("c) Serpiente");
			System.out.println("d) Gato");
			respuesta4 = sc.nextLine().toLowerCase();
				        
			while (!respuesta4.equals("a") && !respuesta4.equals("b") && !respuesta4.equals("c") && !respuesta4.equals("d")) {
					System.out.println("Esa no es la respuesta. Tienes otro intento");
					respuesta4 = sc.nextLine().toLowerCase();
			}	   
					    
				if (respuesta4.equals("a")) {
					puntuacionTrivial++;
			        System.out.println("¡Correcto!");
			        System.out.println("");
			          
				} else {
			        System.out.println("No has acertado, la respuesta correcta es: el león.");
			        System.out.println("");
			    }
				  
			System.out.println("Has terminado el rompecabezas. Tu puntuación es: " + puntuacionTrivial + "/4");
				        
		    if (puntuacionTrivial == 4) {
		    	System.out.println("¡Felicidades! Has ganado el rompecabezas del Antiguo Egipto.");
				puntuacion = 20;
				System.out.println("");
				            
			} else {
				System.out.println("No habéis acertado todas las respuestas, como castigo te retiro un uso de tu ataque especial " + personaje);
				System.out.println("");
			}
				       
			System.out.println("Pasáis a la siguiente cámara, donde os encontráis con Imhotep, sabio sacerdote del Antigüo Egipto, guardián de las almas.");
			System.out.println("''¿Os atrevéis a adentraros en las entrañas del conocimiento prohibido?''");
			System.out.println("Para poder superar esta prueba, tenéis que acertar la palabra secreta. Si falláis, el alma de uno de vosotros quedará atrapada aquí."); 
			System.out.println("PISTA: Seth, Anubis, Horus, Osiris, Sekhmet");
			System.out.println(" ");
    }
}  


