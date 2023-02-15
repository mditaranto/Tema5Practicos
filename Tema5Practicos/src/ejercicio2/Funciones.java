package ejercicio2;

import java.util.Scanner;

public class Funciones {

	static int numero;
	static float jugador;

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

	static float suma() {
		
		if (numero < 8) {
		jugador += numero;
		} else {
			jugador += 0.5;
		}
		return jugador;
	}
	
	static float pedirCartas(String respuesta) {
		
		float suma = 0;
		
		if (respuesta.equals("S")) {
			System.out.println("Ha sacado: ");
			System.out.println(Funciones.Carta());
			suma = Funciones.suma();
			
			System.out.println("¿Desea sacar otra carta?");
			
		} else if (respuesta.equals("N")) {
			System.out.println("Se acabo su turno");
		} else {
			System.out.println("Respuesta incorrecta. Introduzca [S] o [N]");
		}
		
		return suma;
	}

	static void Ganador(float jugador1, float jugador2) {
		jugador1 -= 7.5;
		jugador2 -= 7.5;
		
		Math.abs(jugador1);
		Math.abs(jugador2);
		
		if (jugador1 == 0 && jugador2 == 0) {
			System.out.println("Empate");
		} else if (jugador1 < jugador2) {
			System.out.println("Gana jugador 1");
		} else {
			System.out.println("Gana jugador 2");
		}
	}
}
