package ejercicios;

// Importamos las librerías encesarias
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTextoBuff {

	public static void main(String[] args) {
		File f = new File("./src/archivosEjemplo/EscrituraBuff.txt"); // Creamos la variable del archivo en el que vamos a escribir
		try {
			FileWriter fw = new FileWriter(f); // Creamos el FileWriter que usaremos para escribir en el archivo, se lo pasamos como argumento al constructor
			String cadena = "Este es un texto de ejemplo"; // Esta es la cadena que escribiremos en el archivo
			fw.write(cadena, 0, cadena.length()); // Utilizamos el método write indicando la cadena a escribir, la posición de inicio y la última posición
			fw.flush(); // Hacemos flush para que se guarde en el archivo.
			fw.close(); // Cerramos el FileWriter
		} catch (IOException e) {
			e.printStackTrace(); // Si la ruta no fuera válido, imprimimos un mensaje de error
		}
	}

}
