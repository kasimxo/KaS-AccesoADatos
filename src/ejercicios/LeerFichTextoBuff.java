package ejercicios;

import java.io.File;
import java.io.FileReader;


public class LeerFichTextoBuff {

	public static void main(String[] args) {
		
      try {
	  		File f; // Creamos la variable del archivo
			if(args.length>=1) {
				f = new File(args[0]); //Si se ha introducido una ruta como argumento, utilizamos esa ruta para leer el archivo
			} else {
				f = new File("./src/archivosEjemplo/Ejemplo1.txt"); //Si no se ha introducido una ruta, lee una ruta por defecto
			}		
	        FileReader fic = new FileReader(f); // Creamos el lector
	        int i; // Creamos la variable que recojera el carácter actual
	        while ((i = fic.read()) != -1) { // Recorremos todo el archivo
	           System.out.print((char) i);  // Imprimimos el caracter actual que estamos leyendo
	        }
	        fic.close(); // Cerramos el lector
			}catch (Exception e) {
			   e.printStackTrace(); // Si la ruta introducida no es válido, imprimimos el error
		}
		

	}

}
