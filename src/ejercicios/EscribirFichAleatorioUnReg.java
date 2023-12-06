package ejercicios;

import java.io.File;
import java.io.RandomAccessFile;

public class EscribirFichAleatorioUnReg {

	public static void main(String[] args) {
		File f = new File("./src/archivosEjemplo/EscrituraAleatorioUnReg.txt"); // Creamos la variable del archivo sobre el que vamos a escribir
		
		String[] nombre = {"Ignacios", "Andresas", "Victoria", "Marquito", "JoseManu", "Cristina", "Santiago","Antonios","Albertos"}; // Un array de la información que escribiremos
		// Es importante que cumpla con el formato adecuado, es decir, que tengan los mismos bytes. En este caso son de la misma longitud, pero si podrían hacer funciones que se aseguraran de ello
		
		String registro = nombre[(int) (Math.random()*(nombre.length))]; // Escogemos un nombre aleatorio para escribir
		
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw"); // Creamos la variable de acceso aleatorio a un fichero
			
			long tam = f.length()/8; // Creamos una variable de longitud teniendo en cuenta la longitud de los registros
			
			raf.seek((int)(Math.random()*tam)*8); // Aquí apuntamos a una posición aleatoria del archivo teniendo en cuenta el tamaño de los registros
			
			raf.write(registro.getBytes()); // Escribimos los bytes de la cadena del registro sobre la posición especificada
			raf.close(); // Cerramos la variable
		} catch (Exception e) {
			e.printStackTrace(); // Si se produce cualquier error, lo mostramos por pantalla
		}

	}

}
