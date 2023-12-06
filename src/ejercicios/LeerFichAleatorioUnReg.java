package ejercicios;

import java.io.File;
import java.io.RandomAccessFile;

public class LeerFichAleatorioUnReg {

	public static void main(String[] args) {
		File f = new File("./src/archivosEjemplo/EscrituraAleatorioUnReg.txt"); // Creamos la variable del archivo sobre el que vamos a escribir
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw"); // Creamos la variable de acceso aleatorio a un fichero
			
			long tam = f.length()/8; // Creamos una variable de longitud teniendo en cuenta la longitud de los registros
			
			raf.seek((int)(Math.random()*tam)*8); // Aquí apuntamos a una posición aleatoria del archivo teniendo en cuenta el tamaño de los registros
			
			for(int i = 0; i<8; i++) { // Vamos iterando sobre el registro
				System.out.print((char)raf.read()); // Leemos el caracter actual
			}
			

			raf.close(); // Cerramos la variable
		} catch (Exception e) {
			e.printStackTrace(); // Si se produce cualquier error, lo mostramos por pantalla
		}

	}

}
