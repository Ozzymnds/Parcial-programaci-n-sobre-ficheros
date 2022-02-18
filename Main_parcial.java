package Parcial_Titanic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_parcial {
	private static void Lectura(String fichero) throws FileNotFoundException {
		int contador = 0;
		int contadorH = 0;
		int contadorM = 0;
		int muertos = 0;
		int muertas = 0;
		double porcVarones = 0;
		double porcDamas = 0;
		File doc = new File(fichero);
		try {
			Scanner f = new Scanner(doc);
			while(f.hasNextLine()) {
				//Una vez creados el Scanner y las variables que necesitamos pasamos por un 'while' para que la m�quina lea el fichero l�nea por l�nea
				String linea = f.nextLine();
				String [] linesep = linea.split(","); //Creamos una tabla de 'Strings' para recorrer el fichero con un bucle 'for'
				for(int i = 0; i < linesep.length; i++) {
					//Aqu� hemos escrito 'i == 11' en base al n�mero de columnas del fichero csv, por lo que para conseguir el n� total de pasajeros nos sirve
					if(i == 11) {
						contador++;
					}
					//sirve para contar el n� de hombres
					if(linesep[i].equals("male")) {
						contadorH++;
					}
					//sirve para contar el n� de mujeres
					else if(linesep[i].equals("female")) {
						contadorM++;
					}
					//sirve para contar el n� de hombres muertos
					if(linesep[i].equals("male") && linesep[1].equals("0")) {
						muertos++;
					}
					//sirve para contar el n� de mujeres muertas
					else if(linesep[i].equals("female") && linesep[1].equals("0")) {
						muertas++;
					}
				}
			}
			//f�rmula para el porcentaje: n� de muertos x 100 partido del n� de personas del sexo en cuesti�n
			porcVarones = (muertos * 100)/ contadorH;
			porcDamas = (muertas * 100)/ contadorM;
			//cadena de prints para mostrar os resultados de los condicionales anteriores
			System.out.println("Pasajeros: " + contador);
			System.out.println("Hombres: " + contadorH);
			System.out.println("Mujeres: " + contadorM);
			System.out.println("Hombres muertos: " + muertos);
			System.out.println("Mujeres muertas: " + muertas);
			System.out.println("Muertos y su porcentaje: " + porcVarones + "%");
			System.out.println("Muertas y su porcentaje: " + porcDamas + "%");
			f.close();
			
		} catch(FileNotFoundException e) { //si la ruta est� mal escrita o inventada dar� error
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}
	/*
	 * Pre: ---
	 * Post: Nos piden que leamos un fichero csv para luego poder mostrar determinadas consultas sobre dicha hoja de c�lculo
	 */

	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ruta del archivo y nombre del fichero: ");
		String fichero = sc.next();
		Lectura(fichero);
	}
}
//C:\Users\jmsan\Desktop\GRADO\PROGRAMACI�N\titanic.csv