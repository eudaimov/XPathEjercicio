package vista;
import controlador.Comprobaciones;
import controlador.XPathPropio;

import java.util.InputMismatchException;
import java.util.Scanner;
//Importar Comprobaciones haya donde este

public class Menu {
	public static void crearMenu() {

		boolean comprobacion = true;
		do {
			System.out.println("Elija una de las siguientes opciones");
			System.out.println("0. Para Salir");
			System.out.println("1. Mostrar todos los titulos.");
			System.out.println("2. Para todos los autores");
			System.out.println("3. Ver el libro por ordenación");
			System.out.println("4. Aquellos libros cuyo precio sea inferior al que usted marque");
			//Tienes que importar la clase Comprobaciones
			Integer opcion = Comprobaciones.numero(0, 4);
			XPathPropio mixpath = new XPathPropio();
			switch (opcion) {
			case 1:
				mixpath.Ejercicio1();
				break;
			case 2:
				mixpath.Ejercicio2();

				break;
			case 3:
				mixpath.Ejercicio3();

				break;
			case 4:
				mixpath.Ejercicio4();

				break;
			case 0:
				System.out.println("Hasta pronto");
				comprobacion = false;
				break;
			default:
				break;
			}
			if(opcion!=0) {
				System.out.println("Pulse cualquier tecla + Enter para continuar...");
				String pausa = Comprobaciones.cadenaCaracteres(1000);
			}
		} while (comprobacion);

	}
}