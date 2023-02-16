package ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Creacion de variables necesarias
		float jugador1 = 0;
		float jugador2 = 0;
		String respuesta;

		Scanner sca = new Scanner(System.in);
		
		//Introduzcion al juego
		System.out.println("Que comienze el juego");
		System.out.println("Jugador 1: ");
		System.out.println("¿Desea sacar una carta?");

		respuesta = sca.next();

		//Se muestra al jugador su puntuacion y se genera un bucle hasta que no quiera sacar mas cartas
		while (respuesta.equals("S") && Funciones.jugador < 7.5) {

			jugador1 = Funciones.pedirCartas(respuesta);
			System.out.println("Su puntuacion actual es: " + jugador1);
			if (Funciones.jugador < 7.5) {
				System.out.println("¿Desea sacar otra carta?");
				respuesta = sca.next();
			}
		}

		//Se acaba el jugador 1 y empieza el jugador 2
		System.out.println("Se ha acabado su turno");
		System.out.println("Turno de Jugador 2: ");
		Funciones.jugador = 0;

		respuesta = sca.next();

		//Se muestra al jugador su puntuacion y se genera un bucle hasta que no quiera sacar mas cartas
		while (respuesta.equals("S") && Funciones.jugador < 7.5) {

			jugador2 = Funciones.pedirCartas(respuesta);
			System.out.println("Su puntuacion actual es: " + jugador2);
			if (Funciones.jugador < 7.5) {
				System.out.println("¿Desea sacar otra carta?");
				respuesta = sca.next();
			}

		}
		
		//Se acaba y se muestra la clasificacion
		System.out.println("Se ha acabado su turno");
		System.out.println("Hora del recuento");
		Funciones.Ganador(jugador1, jugador2);
		
		sca.close();
	}
}
