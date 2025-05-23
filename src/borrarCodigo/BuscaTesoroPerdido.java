package borrarCodigo;

import java.util.Random;
import java.util.Scanner;

public class BuscaTesoroPerdido {
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner (System.in);
		Random random = new Random ();
			
		//TODO VARIABLES
		
		//Inicio
				
		String contraseña;
		boolean contraseñaCorrecta = false;
		String personaje;
					
		//Vidas
				
		int vidaUsuario = 0;
		int vidaEnemigo = 600;
				
		//Rompecabezas
				
		String respuestaUsuario = "";
		int numeroadivinar = random.nextInt(10);
		int adivina = 638291726;
		int eleccionJugador;
		int eleccionOponente = random.nextInt(3);
		boolean juegoActivo = true;
		int intentosR = 3;
		int puntosEnemigo = 0;
	    int puntosUsuario = 0;
	    int puntuacionTrivial = 0;
	    String respuesta1 = "";
	    String respuesta2 = "";
	    String respuesta3 = "";
	    String respuesta4 = "";
	    int numeroJuegosGanados = 0;
	    int respuestaFinal;
	    int intentosRestantes = 6; 
	    boolean palabraAdivinada = false;
	    boolean letraEncontrada = false;
	    String entrada = "";
	      
	        
		//Arrays
		    
		String[] opciones = {"Piedra", "Papel", "Tijera"};
		String[] palabras = {"Seth", "Anubis", "Horus", "Osiris", "Sekhmet"};
		String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];
		int longitud = palabraSecreta.length();
		char [] letrasAdivinadas = new char[longitud];
				
		//Ataques
		
		int inicioPelea = random.nextInt(2);
		
		int ataqueBasico = 0;
		int ataqueFuerte = 0;
		int habilidadEspecial = 0;
					
		boolean armaTocha = false;
		int ataqueArmaTocha = 999999999;
		int ataqueAleatorio = random.nextInt(101);	
		int ataqueEnemigo = 50;	
		int eleccionCombate = 0;
								
		//Inicio + elección personaje
				
		System.out.println("                     Bienvenido a                           ");
		System.out.println(" ");
		System.out.println("             山卂尺尺丨ㄖ尺丂 ㄖ千 乇卂乙丨爪卂                  ");
		System.out.println(" ");
		System.out.println("             Desarrolladores: MagicBuilders                  ");
		System.out.println("              Sofia, Harley, Chao, Nicolás                  ");
		System.out.println(" ");
		System.out.println("           .................................                ");
		System.out.println(" ");
		System.out.println("Para que puedas entrar al juego necesito que me digas la contraseña");
		System.out.println("  ");
						
			do {
				System.out.println("Escribe la contraseña: ");
				contraseña = sc.nextLine();
					
				if (contraseña.equalsIgnoreCase("jugones")) {
						contraseñaCorrecta = true;
						System.out.println("¡Enhorabuena! Contraseña correcta, puedes continuar.");
							
				} else {
					System.out.println("Esa no es la contraseña, tienes otro intento.");
					System.out.println("  ");
				}
							
			} while (contraseñaCorrecta == false);
								
			System.out.println("  ");
			System.out.println("Ahora te toca seleccionar el personaje con el que quieres jugar: ");
			System.out.println(" o Cambises");
			System.out.println(" o Bastet");
			System.out.println(" o Ánuket");
				
			personaje = sc.nextLine().toUpperCase();
			System.out.println("  ");
						
				while (!personaje.equalsIgnoreCase("CAMBISES") && !personaje.equalsIgnoreCase("BASTET") && !personaje.equalsIgnoreCase("ÁNUKET")) { 
					System.out.println("Elige un personaje correcto.");
					personaje = sc.nextLine().toUpperCase();
				}
					switch (personaje) {
						
						case "CAMBISES" :
							System.out.println("Cambises tiene una vida de 600 y tiene estas 3 habilidades: básica "
								+ "(espada - 40PA), Berserk (doble espada - 80PA) y Certero (aumenta el ataque +30PA).");
							vidaUsuario = 600;
							ataqueBasico = 40;
							ataqueFuerte = 120;
							habilidadEspecial = 30;
						break;		
							
						case "BASTET":
							System.out.println("Bastet tiene una vida de 700 y tiene  estas 3 habilidades: básica "
								+ "(lanzar objetos - 30PA), Flor Fatal (hiedra venenosa - 70PA) y Alma Voraz (cura 40PV).");
							vidaUsuario = 700;
							ataqueBasico = 30;
							ataqueFuerte = 140;
							habilidadEspecial = 40;
						break;
								
						case "ÁNUKET":
							System.out.println("Ánuket tiene una vida de 650 y tiene estas 3 habilidades: básica "
								+ "(cetro - 30PA), Titán (bestias - 130PA) y Aegis Etéreo (aumenta la defensa +20PA).");
							vidaUsuario = 650;
							ataqueBasico = 30;
							ataqueFuerte = 130;
							habilidadEspecial = 20;
						break;
					}
									
			System.out.println(" ");
			System.out.println("Vamos a comenzar la aventura, debes ir eligiendo tu propio camino. ¡Cuidado! Tus decisiones pueden afectar al desenlace final.");
			System.out.println("  ");
			System.out.println(personaje + " recibe un mensaje de los Dioses avisando de un peligro inminente.");
			System.out.println("Taharka, nigromante exiliado en los tiempos de Amunoketh II, ha regresado. Debe ser detenido a toda costa para evitar la destrucción del reino.");
			System.out.println("Te reúnes con tus aliados: Rashid, Mohamed y Merneith. Decidís que vuestra mejor opción es ir en busca de los soldados de Eazima."
					+ " Unos antigüos y poderosos guerreros,");
			System.out.println("que en tiempos ancestrales ayudaron al reino y esperáis que también lo hagan en esta ocasión.");
				
			System.out.println("    ");
			System.out.println("Os encontráis con el primer rompecabezas en vuestro camino, a las puertas de la Pirámide de Ezhar. Encima de la puerta se lee lo "
				+ "siguiente: ");
			System.out.println("    ");
			System.out.println("Soy eterno, pero nunca envejezco. Mi rostro es de piedra, pero nunca me canso. ");
			System.out.println("Vigilante del sol y del desierto sin fin, en el misterio de las pirámides guardo mi sin fin. ¿Qué soy?");
				
			respuestaUsuario = sc.nextLine();
			
			//Adivinanza Esfinge
			
			while (!respuestaUsuario.equalsIgnoreCase("Esfinge") && !respuestaUsuario.equalsIgnoreCase("La esfinge") && intentosR != 1) {
				            System.out.println (respuestaUsuario + " no es correcto, intentalo de nuevo.");
				            intentosR--;
				            System.out.println("Te quedan " +intentosR+ " intentos restantes.");
				            respuestaUsuario = sc.nextLine();
			}
				        
				if (respuestaUsuario.equalsIgnoreCase("Esfinge") || respuestaUsuario.equalsIgnoreCase("La esfinge")) {
				            System.out.println("¡Es correcto! La puerta se abre ante vosotros");
				            numeroJuegosGanados++;
					
				} else {
						System.out.println("Has gastado todos tus intentos.");
						System.out.println("Al haber fallado la prueba, te quedas sin un uso de tu ataque especial.");
				}
					
			intentosR = 5;
			System.out.println("   ");
			System.out.println("Entráis a la pirámide y os encontráis con la esfinge guardiana de la pirámide.");
			System.out.println("  ");
			System.out.println("Os doy la bienvenida guerreros, pero no puedo dejar que os adentréis en la cámara sin saber si sois dignos.");
			System.out.println("Lo sabré con vuestra respuesta. Tenéis 5 intentos. ");
			System.out.println("   ");
			System.out.println("''Para en la cámara poder entrar el número debéis acertar''");
			
			//Juego adivinar número
			
				while (numeroadivinar != adivina && intentosR != 0) {
					adivina = sc.nextInt();
					            
					while (adivina <= 0 || adivina >= 10) {
						System.out.println("Prueba otra vez");
						adivina = sc.nextInt();
					}
						
					if (adivina > numeroadivinar) {
						System.out.println("Más bajo");
						intentosR--;
						System.out.println("Te quedan " + intentosR +" intentos.");
						System.out.println("");
					}
						            
					if (adivina < numeroadivinar) {
						System.out.println("Más alto");
						intentosR--;
						System.out.println("Te quedan " + intentosR +" intentos.");
						System.out.println("");
					}    
				}
				
				if (intentosR > 0) { 
					System.out.println(" ");
					System.out.println("Adelante, podéis pasar. " + numeroadivinar + " era el número correcto.");
					System.out.println("  ");
					numeroJuegosGanados++;
					
				} else {
					System.out.println("Habeis gastado todos los intentos.");
					System.out.println("Os permitiré la entrada, pero a cambio, al haber fallado la prueba te quedas sin un uso de tu ataque especial.");
					System.out.println("");
				}
					
			System.out.println("La esfinge os deja paso a la cámara.");
			System.out.println("Allí os encontráis a un guardián, que os dice que está muy solo y os pide compañía. Os propone jugar con él a piedra, papel o tijera.");
			System.out.println(" ");
			System.out.println("Si ganáis de manera justa, os permitirá continuar. El juego será al mejor de tres.");
			
			//Juego piedra, papel o tijera
			
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
				numeroJuegosGanados++;
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
			
			//Trivial Egipto
			
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
				numeroJuegosGanados++;
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
			
			// Juego ahorcado
			
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
					numeroJuegosGanados++;
				}

			//Decisión Ammit
				
			if (numeroJuegosGanados == 5) {
				System.out.println("  ");
				System.out.println("Al haber ganado todos los desafíos, se abre ante vosotros una puerta oculta en la pared");
				System.out.println("De pronto aparece una gran sombra, al mirar más detenidamente veis que se trata de Ammit");
				System.out.println("Trae malas noticias con ella, ya que los valiosos soldados de Eazima han sido destruidos......");
				System.out.println("Os dice que en cambio, tras las puertas se guarda un gran y valioso tesoro, quien las cruce tendrá oro, gloria y poder sin igual para"
					+ " derrotar a Taharka");
				System.out.println("Pero sólo uno podrá acceder, dejando de lado al resto");
				System.out.println(" ");
				System.out.println("Ammit también os da la opción de que continuéis juntos, con su bendición, pero deberéis enfrentaros a Taharka sin ayuda de los soldados");
				System.out.println(" ");
				System.out.println(personaje + ", ¿cuál es tu elección?");
				System.out.println("1. Dejar de lado a mis fieles compañeros");
				System.out.println("2. Seguir juntos hasta el final");
				System.out.println("Debes elegir ahora");
				respuestaFinal = sc.nextInt();
				        	
				while (respuestaFinal != 1 && respuestaFinal != 2) {
					System.out.println("No entiendo tu respuesta, ¿cual es tú decisión?");
					respuestaFinal = sc.nextInt();
				}
			
					if (respuestaFinal == 1) {
						System.out.println(" ");
						System.out.println("Por ser un avaricioso, sufrirás la ira de todos los dioses y tu alma será devorada en el Duat");
						vidaUsuario = 0;
						juegoActivo = false;     		
					}
					    
					if (respuestaFinal == 2) {
						System.out.println(" ");
					 	System.out.println("Por tu lealtad a tus compañeros, te concederé mayor poder del que jamás podrías imaginar para la batalla que acontece");
						armaTocha = true;
						juegoActivo = true;
					
						System.out.println("  ");
						System.out.println("Con la bendición de Ammit, tus compañeros y tú continuáis adelante.");
						System.out.println("Os armáis de valor, ya que sabéis que estáis solos y que no podéis contar con la fuerza de los soldados de Eazima");
						System.out.println("Pero habéis llegado hasta aquí demostrando valor, inteligencia y entereza");
						System.out.println("  ");
						
					}
					
				} else {
					System.out.println(" ");
					System.out.println("Entráis en la cámara final, donde debían estar los soldados y allí os espera Taharka, vestido con su armadura dorada, en compañía de"
							+ " Uraeus, su fiel aliada y con el Papiro de Damasco en la mano. ");
					System.out.println("Está a punto de liberar a las sombras para desatar el caos en todo Egipto y gobernar por encima de todos");
					System.out.println(" ");
				}
			

				        				
			// Batalla
			
			if (inicioPelea == 0 && juegoActivo == true) {
				System.out.println("Taharka te ataca y empieza la pelea");
				System.out.println("");
				        	
				while (vidaUsuario > 0 && vidaEnemigo > 0) {
					System.out.println("Taharka te ataca y te quita " + ataqueEnemigo + " puntos de vida");
					vidaUsuario = vidaUsuario - ataqueEnemigo;
					        	
					if (vidaUsuario < 0) {
						vidaUsuario = 0;
			        }
				        	
					System.out.println("Te quedan "+ vidaUsuario + " puntos de vida");
					System.out.println("");
					        	
					if (vidaUsuario > 0) {
				        		
					//Menú combate con opciones dependiendo del personaje
						
					System.out.println("¿Que ataque te gustaría hacer?");
					System.out.println("1. Ataque Básico: " + ataqueBasico + " puntos de daño");
					
					if (personaje.equalsIgnoreCase("CAMBISES")) {
						System.out.println("2. Certero: Aumenta el ataque en " + habilidadEspecial + " puntos de ataque");
					}
					
					if (personaje.equalsIgnoreCase("BASTET")) {
						System.out.println("2. Alma Voraz: te curas " + habilidadEspecial + " puntos de vida");
					}
					
					if (personaje.equalsIgnoreCase("ÁNUKET")) {
						System.out.println("2. Aegis Etéreo: aumenta la defensa en " + habilidadEspecial + " puntos");     
					}
					
					if (numeroJuegosGanados > 0) {
						System.out.println("3. Ataque fuerte: " + ataqueFuerte + " puntos de daño. Con " + numeroJuegosGanados + " usos restantes");        	
					}
					        	
					if (armaTocha == true) {
							System.out.println("4. Favor de Ammit: " + ataqueArmaTocha + " puntos de daño");    	
					}
					        	
					eleccionCombate = sc.nextInt();
		        	
					while (eleccionCombate < 0 || eleccionCombate > 5) {
						System.out.println("No puedes hacer eso. ¿Que quieres hacer?");
						eleccionCombate = sc.nextInt();        	
					}
					
						//Ataque del usuario
					
						if (eleccionCombate == 1) {
							ataqueAleatorio = random.nextInt(101);
					        		
							if (ataqueAleatorio > 50) {
								vidaEnemigo = vidaEnemigo - ataqueBasico;		
								System.out.println("Usas el ataque básico y le quitas " + ataqueBasico + " puntos de vida a Taharka ");
						        		
								if (vidaEnemigo < 0) {
									vidaEnemigo = 0;		
								}
						        
								System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");   
							}
						        		
							if (ataqueAleatorio <= 25) {			
								System.out.println("Usas el ataque básico pero Taharka lo esquiva");    		
							}
							
						    if (ataqueAleatorio >= 26 && ataqueAleatorio <= 49) {
						    	ataqueBasico = ataqueBasico/2;			
						    	vidaEnemigo = vidaEnemigo - ataqueBasico;
						        System.out.println("Usas el ataque básico pero solo le quitas " + ataqueBasico + " puntos de vida a Taharka, una sombra le ha protegido");
							    
						        if (vidaEnemigo < 0) {
						        	vidaEnemigo = 0;
							    }
						        
						        System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");			
						        ataqueBasico = ataqueBasico*2;    		
						    }	
						}
						
					    if (eleccionCombate == 2) {
					        		
					    	if (personaje.equalsIgnoreCase("CAMBISES")) {		
					    		System.out.println("Aumentas tu ataque en " + habilidadEspecial + " puntos");		
					    		ataqueBasico = ataqueBasico + habilidadEspecial;		
					    		ataqueFuerte = ataqueFuerte + habilidadEspecial;    	
					    	}
						        	
					    	if (personaje.equalsIgnoreCase("BASTET")) {
					    		System.out.println("Te curas " + habilidadEspecial + " puntos de vida");
					    		vidaUsuario = vidaUsuario + habilidadEspecial;
						        
					    		if (vidaUsuario > 700) {		
					    			vidaUsuario = 700;		
					    		}
					    		
						        System.out.println("Ahora tienes " + vidaUsuario + " puntos de vida");
						    }
						        	
					    	if (personaje.equalsIgnoreCase("ÁNUKET")) {
					    		System.out.println("2. Aegis Etéreo: aumenta la defensa en " + habilidadEspecial + " puntos");
					    		ataqueEnemigo = ataqueEnemigo - habilidadEspecial;   	
					    	}   	
					    }
					    
					    if (eleccionCombate == 3 && numeroJuegosGanados > 0) {
					    	ataqueAleatorio = random.nextInt(101);
					        
					    	if (ataqueAleatorio > 50) {
					    		System.out.println("Usas el ataque fuerte y le quitas " + ataqueFuerte + " puntos de vida");
					    		vidaEnemigo = vidaEnemigo - ataqueFuerte;
					    		numeroJuegosGanados--;
					        	
					    	if (vidaEnemigo < 0) {
					    		vidaEnemigo = 0;		
					    	}
					        		
					    	System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");
					        		
					    	}
					        
					    	if (ataqueAleatorio <= 25) {
					    		System.out.println("Usas el ataque fuerte pero Taharka consigue esquivar tu ataque");
					    		numeroJuegosGanados--;
					    	} 
					        
					    	if (ataqueAleatorio >= 26 && ataqueAleatorio <= 49) {
					    		ataqueFuerte = ataqueFuerte/2;
					    		vidaEnemigo = vidaEnemigo - ataqueFuerte;
					        	
					    		System.out.println("Usas el ataque básico pero sólo le quitas " + ataqueFuerte + " puntos de vida a Taharka");
						        
					    		if (vidaEnemigo < 0) {
					    			vidaEnemigo = 0;
					    		}
					        			
					    		System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");
					    		ataqueFuerte = ataqueFuerte*2;
					    		numeroJuegosGanados--;	
					    	}    
					    }
					    
					    if (eleccionCombate == 4 && armaTocha == true) {
					    	System.out.println("Usas el favor de Ammit y le quitas " + ataqueArmaTocha + " puntos de vida");
					    	vidaEnemigo = vidaEnemigo - ataqueArmaTocha;
					        
					    	if (vidaEnemigo < 0) {
					    		vidaEnemigo = 0;
					    	}   
					    }   
					}
				}
				
			}
				        
			//Segunda opción de pelea	        
				        	
			if (inicioPelea == 1 && juegoActivo == true) {
				System.out.println("Empiezas la pelea");
				System.out.println("");
				
				while (vidaUsuario > 0 && vidaEnemigo > 0) {    		
					System.out.println("¿Que ataque te gustaría hacer?");
					System.out.println("1. Ataque Básico: " + ataqueBasico + " puntos de daño");
					
					if (personaje.equalsIgnoreCase("CAMBISES")) {
						System.out.println("2. Certero: aumenta el ataque en " + habilidadEspecial + " puntos");
					}
					        	
					if (personaje.equalsIgnoreCase("BASTET")) {
						System.out.println("2. Alma Voraz: te curas " + habilidadEspecial + " puntos de vida");   
					}
					
					if (personaje.equalsIgnoreCase("ÁNUKET")) {
						System.out.println("2. Aegis Etéreo: aumenta la defensa en " + habilidadEspecial + " puntos");
					}
					        	
					if (numeroJuegosGanados > 0) {
						System.out.println("3. Ataque fuerte: " + ataqueFuerte + " puntos de daño. " + numeroJuegosGanados + " usos restantes");
					}
					
					if (armaTocha == true) {        		
						System.out.println("4. Favor de Ammit: " + ataqueArmaTocha + " puntos de daño");
					}
					        	
					eleccionCombate = sc.nextInt();
					
					while (eleccionCombate < 0 || eleccionCombate > 5) {
						System.out.println("No puedes hacer eso. ¿Que quieres hacer?");
						eleccionCombate = sc.nextInt();
					}
					        	
					//Ataque del usuario
					        	
					if (eleccionCombate == 1) {      		
						ataqueAleatorio = random.nextInt(101);
						
						if (ataqueAleatorio > 50) {
							vidaEnemigo = vidaEnemigo - ataqueBasico;
							System.out.println("Usas el ataque básico y le quitas " + ataqueBasico + " puntos de vida a Taharka");
					        
							if (vidaEnemigo < 0) {
								vidaEnemigo = 0;
							}
					        		
							System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");    
						}
					        		
						if (ataqueAleatorio <= 25) {
							System.out.println("Usas el ataque básico pero Taharka esquiva tu ataque");    		
						}
					        		
						if (ataqueAleatorio >= 26 && ataqueAleatorio <= 49) {
							ataqueBasico = ataqueBasico/2;
							vidaEnemigo = vidaEnemigo - ataqueBasico;
							System.out.println("Usas el ataque básico pero solo le quitas " + ataqueBasico + " puntos de vida a Taharka");
						    System.out.println("");
							
						    if (vidaEnemigo < 0) {
								vidaEnemigo = 0;
							}
					        			
						    System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");
						    ataqueBasico = ataqueBasico*2;		
						}
					}
					        	
					if (eleccionCombate == 2) {
					
						if (personaje.equalsIgnoreCase("CAMBISES")) {
							System.out.println("Aumentas tu ataque en " + habilidadEspecial + " puntos");
							ataqueBasico = ataqueBasico + habilidadEspecial;
							ataqueFuerte = ataqueFuerte + habilidadEspecial;
						}
						
						if (personaje.equalsIgnoreCase("BASTET")) {
							System.out.println("Te curas " + habilidadEspecial + " puntos de vida");
							vidaUsuario = vidaUsuario + habilidadEspecial;
						    
							if (vidaUsuario > 700) {
								vidaUsuario = 700;
							}
							
							System.out.println("Ahora tienes " + vidaUsuario + " puntos de vida");
						}
						
						if (personaje.equalsIgnoreCase("ÁNUKET")) {
							System.out.println("2. Aegis Etéreo: aumenta la defensa en " + habilidadEspecial + " puntos");
							ataqueEnemigo = ataqueEnemigo - habilidadEspecial;
						}
					}
					
					if (eleccionCombate == 3 && numeroJuegosGanados > 0) {
						ataqueAleatorio = random.nextInt(101);
					   
						if (ataqueAleatorio > 50) {     		
							System.out.println("Usas el ataque fuerte y le quitas a Taharka " + ataqueFuerte + " puntos de vida");
							vidaEnemigo = vidaEnemigo - ataqueFuerte;
							numeroJuegosGanados--;
							
							if (vidaEnemigo < 0) {
								vidaEnemigo = 0;
							}
					        
							System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");  
						}
					    
						if (ataqueAleatorio <= 25) {
							System.out.println("Usas el ataque fuerte pero Taharka esquiva tu ataque");
							numeroJuegosGanados--;
						} 
					    
						if (ataqueAleatorio >= 26 && ataqueAleatorio <= 49) {
							ataqueFuerte = ataqueFuerte/2;
							vidaEnemigo = vidaEnemigo - ataqueFuerte;
							System.out.println("Usas el ataque básico pero solo le quitas " + ataqueFuerte + " puntos de vida a Taharka");
						    
							if (vidaEnemigo < 0) {
								vidaEnemigo = 0;
							}

							System.out.println("Le quedan " + vidaEnemigo + " puntos de vida");
							ataqueFuerte = ataqueFuerte*2;					        
							numeroJuegosGanados--;
						}
					}
					
					if (eleccionCombate == 4 && armaTocha == true) {
						System.out.println("Usas el favor de Ammit y le quitas a Taharka " + ataqueArmaTocha + " puntos de vida");
						vidaEnemigo = vidaEnemigo - ataqueArmaTocha;
					    
						if (vidaEnemigo < 0) {
							vidaEnemigo = 0;
						}
					}
					
					if (vidaEnemigo > 0) {
						System.out.println("El enemigo ataca y te quita " + ataqueEnemigo + " puntos de vida");
						vidaUsuario = vidaUsuario - ataqueEnemigo;
					    
						if (vidaUsuario < 0) {
							vidaUsuario = 0;
						}
					    
						System.out.println("Te quedan "+ vidaUsuario + " puntos de vida");
						System.out.println("");
					}
				} 
				     
			}
				        	       	
			//FIN DE LA SIGUIENTE OPCION DE PELEA
			
			if (vidaUsuario == 0) {
				System.out.println(" ");
				System.out.println("Has muerto. Egipto se sume en un profundo caos.");
				System.out.println("El sol, alguna vez brillante y cálido sobre las tierras de Egipto, ahora está opacado por nubes oscuras que bloquean su luz. "
						+ "Las aguas del Nilo, fuente de vida para el imperio, se han vuelto turbias y peligrosas, arrastrando con ellas plagas que asolan los campos y aldeas.");
				System.out.println("FIN DEL JUEGO");
			}
			
			if (vidaEnemigo == 0) {
				System.out.println(" ");
				System.out.println("¡¡¡Taharka ha sido derrotado!!!");	
				System.out.println("Sus gritos se escuchan desde todo Egipto, mientras su figura se disuelve lentamente en un torbellino de energía negra, "
						+ "un reflejo de lo que una vez fue."); 	
			}	
			
			sc.close();
	}
}