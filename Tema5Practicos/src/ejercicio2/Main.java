package ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		float jugador1 = 0;
		float jugador2 = 0;
		String respuesta;

		Scanner sca = new Scanner(System.in);

		System.out.println("Que comienze el juego");
		System.out.println("Jugador 1: ");
		System.out.println("¿Desea sacar una carta?");

		do {
			respuesta = sca.next();
			jugador1 = Funciones.pedirCartas(respuesta);
			System.out.println("Su puntuacion actual es: " + jugador1);
		} while (respuesta.equals("S"));
		
		System.out.println("Turno de Jugador 2: ");
		
		do {
			respuesta = sca.next();
			jugador2 = Funciones.pedirCartas(respuesta);
			System.out.println("Su puntuacion actual es: " + jugador2);
		} while (respuesta.equals("S"));
		
		Funciones.Ganador(jugador1, jugador2);
		
	}

}
