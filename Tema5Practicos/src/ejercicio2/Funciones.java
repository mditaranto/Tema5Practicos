package ejercicio2;


public class Funciones {

	/**
	 * Atributo para guardar el valor de la carta
	 */
	static int numero;
	
	/**
	 * Atributo para guardar la puntuacion de los jugadores
	 */
	static float jugador;

	/**
	 * En este metodo se genera la carta en forma de String de forma aleatoria
	 * @return La carta en forma de String
	 */
	static String Carta() {
		String carta = "";
		int palo;
		numero = (int) (Math.random() * (10) + 1);
		palo = (int) (Math.random() * (4) + 1);

		switch (numero) {
		case 1 -> {
			carta = "uno de ";
		}
		case 2 -> {
			carta = "dos de ";
		}
		case 3 -> {
			carta = "tres de ";
		}
		case 4 -> {
			carta = "cuatro de ";
		}
		case 5 -> {
			carta = "cinco de ";
		}
		case 6 -> {
			carta = "seis de ";
		}
		case 7 -> {
			carta = "siete de ";
		}
		case 8 -> {
			carta = "sota de ";
		}
		case 9 -> {
			carta = "caballo de ";
		}
		case 10 -> {
			carta = "rey de ";
		}
		}

		switch (palo) {
		case 1 -> {
			carta += "oros";
		}
		case 2 -> {
			carta += "copas";
		}
		case 3 -> {
			carta += "espadas";
		}
		case 4 -> {
			carta += "bastos";
		}
		}
		return carta;
	}

	/**
	 * En este metodo se suma el valor de la carta a la puntuacion
	 * @return El nuevo valor de la puntuacion
	 */
	static float suma() {
		
		if (numero < 8) {
		jugador += numero;
		} else {
			jugador += 0.5;
		}
		return jugador;
	}
	
	/**
	 * Este metodo recoge las respuestas y ejecuta a raiz de ellas
	 * @param respuesta del jugador
	 * @return El valor de la puntuacion
	 */
	static float pedirCartas(String respuesta) {
		
		float suma = 0;
		
		if (respuesta.equals("S")) {
			System.out.println("Ha sacado: ");
			System.out.println(Funciones.Carta());
			suma = Funciones.suma();
	
		} else {
			System.out.println("Respuesta incorrecta. Introduzca [S] o [N]");
		}
		
		
		return suma;
	}

	/**
	 * Este metodo indica quien gano o si empataron
	 * @param jugador1
	 * @param jugador2
	 */
	static void Ganador(float jugador1, float jugador2) {
		jugador1 -= 7.5;
		jugador2 -= 7.5;
		
		if (jugador1 == jugador2) {
			System.out.println("Empate");
		}else if (jugador1 > 0 && jugador2 > 0) {
			System.out.println("Empate");
		} else if (jugador1 > 0) {
			System.out.println("Gana jugador 2");
		} else if (jugador2 > 0) {
			System.out.println("Gana jugador 1");
		} else if (jugador1 > jugador2) {
			System.out.println("Gana jugador 1");
		} else {
			System.out.println("Gana jugador 2");
		}
	}
}
