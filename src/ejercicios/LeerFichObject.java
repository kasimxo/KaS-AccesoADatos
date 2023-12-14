package ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import clasesObj.Mascota;

public class LeerFichObject {

	public static void main(String[] args) {
		
		File f = new File("./src/archivosEjemplo/EscrituraObject"); // Creamos la variable del archivo en el que vamos a leer
		
		try {
			
			FileInputStream fis = new FileInputStream(f); // Creamos el flujo de datos con el archivo
			ObjectInputStream ois = new ObjectInputStream(fis); // Creamos el lector de objetos del flujo de datos
			
			Mascota mascota = (Mascota) ois.readObject(); // Leemos el archivo como un objeto y lo convertimos en objeto del tipo Mascota
			
			System.out.println(mascota); // Mostramos por pantalla la mascota leída
			
			fis.close();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // Si se produce un error, lo mostramos
		}
		
		
	}

}
