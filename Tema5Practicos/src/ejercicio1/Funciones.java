package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Funciones {

	/**
	 * Atributo que se usara para guardar los valores del buscaminas
	 */
	static String tabla[] = new String[20];

	/**
	 * Metodo que establece minas aleatorias dentro del atributo
	 */
	static void Minas() {
		//Creacion de una variable donde guardaremos el valor aleatorio
		int aleat;
		//Mediante este for guardamos el valor de 6 minas en lugares diferentes de la tabla
		for (int i = 0; i < 6; i++) {
			do {
				aleat = (int) (Math.random() * 20);
			} while (tabla[aleat] == "*");
			tabla[aleat] = "*";
		}
	}

	/**
	 * Metodo que establece los numeros "1" dentro del atribto
	 */
	static void Unos() {
		//Recorremos la tabla con el for
		for (int i = 0; i < 20; i++) {
			// En caso de haber una mina en la posicion
			if (tabla[i] == "*") {
				//Se comprueba que no son bordes y se rodea la posicion con "1"
				if (i != 0 && tabla[i - 1] != "*") {
					tabla[i - 1] = "1";
				}
				if (i != 19 && tabla[i + 1] != "*") {
					tabla[i + 1] = "1";
				}
			}
		}
	}

	/**
	 * Metodo que establece los numeros "0" y "2" dentro del atributo
	 */
	static void Cerosydos() {
		//Recorremos la tabla con este for
		for (int i = 0; i < 20; i++) {
			//En caso de no haber valor en la posicion, se establece un "0"
			if (tabla[i] == null) {
				tabla[i] = "0";
				//En caso contrario, si la posicion no es una esquina
			} else if (i != 0 && i != 19) {
				//Y esta rodeado de minas, se establece un "2"
				if (tabla[i] == "1" && tabla[i - 1] == "*" && tabla[i + 1] == "*") {
					tabla[i] = "2";
				}
			}
		}
	}

	/**
	 * Metodo que muestra la evolucion de la tabla
	 * @param resuelta Tabla con los valores ocultos
	 * @param posicion Posicion de la tabla que el usuario decide revelar
	 */
	static void MostrarTabla(String resuelta[], int posicion) {
		//Se iguala la posicion de las 2 tablas
		resuelta[posicion].equals(tabla[posicion]);
		//Se revela el nuevo valor de la posicion seleccionada
		System.out.println(Arrays.toString(resuelta));
	}


	/**
	 * Metodo que recoge la posicion seleccionada y segun este valor
	 * se desarrolla en juego
	 */
	static void Jugar() {
		
		//Variable que recoge la posicion del jugador
		int posicion;
		//Variable para establecer una victoria
		int destapados = 0;
		
		//Creamos una tabla donde todos sus valores sean ocultos (¿?)
		String resuelta[] = new String[tabla.length];

		for (int i = 0; i < 20; i++) {
			resuelta[i] = "¿?";
		}

		Scanner sca = new Scanner(System.in);

		posicion = sca.nextInt();

		//Mientras no se cumpla la condicion de victoria
		while (destapados < 14) {
			//Nos aseguramos que el valor introducido este dentro de los valores deseados
			if (posicion <= 20 && posicion >= 1) {
				posicion -= 1; //Restamos 1 a la posicion
				
				//Mediante un switch que lee el valor de la posicion
				switch (tabla[posicion]) {
				//En caso de que no sea una mina
				case "0", "1", "2" -> {
					//Se lleva a la funcion
					Funciones.MostrarTabla(resuelta, posicion);
					destapados++; //Se añade 1 a la condicion de victoria
				}
				//En caso de ser una mina
				case "*" -> {
					//Se le hace saber al usuario y se muestra la tabla al completo
					System.out.println("Ha perdido ");
					System.out.println(Arrays.toString(tabla));
					//Cerramos el bucle
					destapados = 15;
				}
				}
			} else {
				System.out.println("Introduzca una casilla valida [1-20]");
			}
			if (destapados < 14) {
				posicion = sca.nextInt();
			}
		}
		//En caso de haber ganado, se hace saber al usuario
		if (destapados == 14) {
			System.out.println("Enhorabuena");
		}
	}
}
