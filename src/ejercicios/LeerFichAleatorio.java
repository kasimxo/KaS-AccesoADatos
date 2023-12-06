package ejercicios;

// Importamos las librearías necesarias
import java.io.RandomAccessFile;
import java.io.File;

public class LeerFichAleatorio {

	public static void main(String[] args) {
		
		File f = new File("./src/archivosEjemplo/EscrituraAleatorio.txt"); // Creamos la variable del archivo que vamos a leer
		
		try {
			
			RandomAccessFile raf = new RandomAccessFile(f, "r"); // Creamos la variable de acceso aleatorio al fichero

			raf.seek((int) (Math.random()*f.length())); // Nos posicionamos en un lugar aleatorio del fichero
			System.out.println((char) raf.read()); // Leemos el caracter en la posición aleatoria
			
			raf.close(); // Cerramos el acceso de archivo aleatorio
			
		} catch (Exception e) {
			e.printStackTrace(); // Si sucede un error, lo mostramos
		}
	}

}
