package controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Comprobaciones {
	public static Integer numero(Integer limiteMinimo, Integer limiteMaximo) {
		Scanner teclado = new Scanner(System.in);
		Integer numero = null;
		boolean comprobacion = true;
		do {
			try {
				numero = teclado.nextInt();
				if(numero>=limiteMinimo && numero<=limiteMaximo) {
					comprobacion=false;
				}else {
					System.out.printf("El número %d se encuentra fuera del rango permitido (Del %d al %d)\n vuelva a intentarlo, gracias\n",numero,limiteMinimo, limiteMaximo);
				}

			} catch (InputMismatchException e) {
				System.out.println("Este valor es irreconocible por el sistema, \npor favor, vuelva a introducir un número");
			}finally {
				teclado.nextLine();
			}
		} while (comprobacion);

		return numero;
	}

    public static boolean pedirSiNo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulse S para Si y N para No (S/N)");
        String declaracion = "";
        boolean resultado = false;
        boolean comprobacion = true;
        do{
            declaracion = teclado.nextLine();
            if(declaracion.equalsIgnoreCase("S")) {
            	comprobacion= false;
            	resultado = true;
            }else if(declaracion.equalsIgnoreCase("N") ){
                comprobacion = false;
                resultado = false;
            }else{
                System.out.println("Valor introducido es incompresible, por favor, unicamente:");
                System.out.println("\tPulse la tecla S seguido de la tecla Intro en caso que su respuesta sea afirmativa");
                System.out.println("\tO");
                System.out.println("\tPulse la tecla N seguido de la tecla Intro en caso que su respuesta sea negativa");
            }
        }while(comprobacion);

        return resultado;
    }
    public static String cadenaCaracteres(Integer longitudMaxima) {

    	Scanner teclado = new Scanner(System.in);
        boolean comprobacion = true;
        String cadenaCaracteres;
        do{
            cadenaCaracteres = teclado.nextLine();
            if(cadenaCaracteres.trim().equals("")){
                System.out.println("Introducir una cadena de caracteres vacia no está permitido,"
                		+"\npor favor, introduzca algún dato:");
            }else{
                comprobacion=false;
            }
        }while(comprobacion);
        //Comprobacion si excede el tamaño máximo de caracteres
        if(cadenaCaracteres.length()>longitudMaxima){
        	System.out.println("Ha excedido la longitud máxima de caracteres permitidos");
        	System.out.println("El texto introducido se ha truncado automáticamente a "+longitudMaxima+" caracteres ('"+cadenaCaracteres.substring(0, longitudMaxima)+"')");
            cadenaCaracteres = cadenaCaracteres.substring(0, longitudMaxima);
        }

    	return cadenaCaracteres;
    }
}
