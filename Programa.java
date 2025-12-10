/**
 * Programa.java
 * @author: Linus Torvalds
 **/
import java.util.Scanner;

public class Programa{
	static Scanner teclado = new Scanner(System.in);
	static Envio[] envios = new Envio[50];
	static Integer iEnvios = 0;

	public static void main(String[] args){
		Boolean repetirMenu = true;
		do{
			switch(verMenu()){
				case "1":
					registrarEnvio();
					break;
				case "2":
					verInforme();
					break;
				case "3":
					enviar();
					break;
				case "X":
				case "x":
					repetirMenu = false;
					break;
				default:
					System.out.println("Opción desconocida.");
			}
		}while(repetirMenu);
		teclado.close();
		System.out.println("Fin del programa. Espero volver a verle pronto.\n");
	}

	public static void verInforme(){
		Float suma = 0f;
		System.out.println("\nINFORME DE ENVÍOS");
		for(int i = 0; i < iEnvios; i++){
			System.out.println("\t" + (i + 1) + ". " + envios[i].verComoString());
			suma += envios[i].precio;
		}
		System.out.println("\t-----------------");
		System.out.println("\tTOTAL:\t\t" + suma + "€\n");
	}

	public static String verMenu(){
		System.out.println("APLICACIÓN DE PaqueteMetes version 1.0");
		System.out.println("\t1. Registrar Envío");
		System.out.println("\t2. Ver Informe de Envíos");
		System.out.println("\t3. Realizar Envío");
		System.out.println("\tX. Salir");
		System.out.print("\tOpción: ");
		return teclado.nextLine();
	}

	public static void registrarEnvio(){
		while(true){
			try{
				System.out.println("\nRegistro de Envío");
				System.out.print("\tNúmero: ");
				String numero = teclado.nextLine();
				if (numero.isEmpty())
					break;
				System.out.print("\tPrecio: ");
				Float precio = Float.valueOf(teclado.nextLine());

				Envio envio = new Envio(numero, precio);
				envios[iEnvios++] = envio;
				
				System.out.println("Registro OK");
			}
			catch(Exception excepcion){
				System.out.println("Registro KO");
			}
		}
	}

	public static void enviar(){
	}
}
