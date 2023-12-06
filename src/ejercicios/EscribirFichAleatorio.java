package ejercicios;

//Importamos las librerías necesarias
import java.io.RandomAccessFile;
import java.io.File;


public class EscribirFichAleatorio {

	public static void main(String[] args) {
		File f = new File("./src/archivosEjemplo/EscrituraAleatorio.txt"); // Creamos la variable del archivo sobre el que vamos a escribir
		
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw"); // Creamos la variable de acceso aleatorio a un fichero
			
			raf.seek((int)(Math.random()*f.length())); // Aquí apuntamos a una posición aleatoria del archivo
			raf.write("Prueba".getBytes()); // Escribimos los bytes de la cadena Prueba sobre la posición especificada
			raf.close(); // Cerramos la variable
		} catch (Exception e) {
			e.printStackTrace(); // Si se produce cualquier error, lo mostramos por pantalla
		}

	}

}
