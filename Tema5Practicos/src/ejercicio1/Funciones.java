package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Funciones {

	static String tabla[] = new String[20];

	static void Minas() {
		int aleat;
		for (int i = 0; i < 6; i++) {
			do {
				aleat = (int) (Math.random() * 20);
			} while (tabla[aleat] == "*");
			tabla[aleat] = "*";
		}
	}

	static void Unos() {
		for (int i = 0; i < 20; i++) {
			if (tabla[i] == "*") {
				if (i != 0 && tabla[i - 1] != "*") {
					tabla[i - 1] = "1";
				}
				if (i != 19 && tabla[i + 1] != "*") {
					tabla[i + 1] = "1";
				}
			}
		}
	}

	static void Cerosydos() {
		for (int i = 0; i < 20; i++) {
			if (tabla[i] == null) {
				tabla[i] = "0";
			} else if (i != 0 && i != 19) {
				if (tabla[i] == "1" && tabla[i - 1] == "*" && tabla[i + 1] == "*") {
					tabla[i] = "2";
				}
			}
		}
	}

	static void MostrarTabla(String resuelta[], int posicion) {
		resuelta[posicion] = tabla[posicion];
		System.out.println(Arrays.toString(resuelta));
	}

	static void tabla() {
		Funciones.Minas();
		Funciones.Unos();
		Funciones.Cerosydos();
	}

	static void Jugar() {
		Funciones.tabla();
		
		int posicion;
		int destapados = 0;
		
		String resuelta[] = new String[tabla.length];

		System.out.println(Arrays.toString(tabla));

		for (int i = 0; i < 20; i++) {
			resuelta[i] = "¿?";
		}

		Scanner sca = new Scanner(System.in);

		posicion = sca.nextInt();

		while (destapados < 14) {
			if (posicion <= 20 && posicion >= 1) {
				posicion -= 1;
				switch (tabla[posicion]) {
				case "0", "1", "2" -> {
					Funciones.MostrarTabla(resuelta, posicion);
					destapados++;
				}
				case "*" -> {
					System.out.println("Ha perdido ");
					System.out.println(Arrays.toString(tabla));
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
		if (destapados == 14) {
			System.out.println("Enhorabuena");
		}
	}
}
