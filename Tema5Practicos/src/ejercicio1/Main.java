package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		//LLamamiento a las funciones encargadas del tablero
		Funciones.Minas();
		Funciones.Unos();
		Funciones.Cerosydos();
		
		//Mensaje de bienvenida y comienzo del juego
		System.out.println("Bienvenido al buscaminas");
		System.out.println("Para empezar introduzca un numero del 1 al 20");
		
		Funciones.Jugar();
		

	}

}
