package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import clasesObj.Mascota;

public class EscribirFichObject {

	public static void main(String[] args) {
		Mascota mascota; // Declaramos la variable del objeto que vamos a escribir
		
		// Generamos unos arrays para construir el objeto
		String[] nombres = {"Coco", "Kira", "Rex", "Seti", "Lua", "Leonarda", "Fito", "Manolito", "Bambi"};
		String[] tipo = {"Perro", "Loro", "Gato", "Conejo", "Periquito", "Tortuga"};
		String[] sexo = {"chico", "chica"};
		
		// Creamos el objeto con un nombre aleatorio, una edad aleatoria, un tipo aleatorio y un sexo aleatorio
		mascota = new Mascota(nombres[(int) Math.round(Math.random()*(nombres.length-1))], (int) Math.round(Math.random()*10), tipo[(int) Math.round(Math.random()*(tipo.length-1))],sexo[(int) Math.round(Math.random()*(sexo.length-1))]);
		
		// Creamos la variable del archivo en el que vamos a escribir
		File f = new File("./src/archivosEjemplo/EscrituraObject");
		
		try {
			FileOutputStream fos = new FileOutputStream(f); // Creamos el flujo de datos que usaremos para escribir en el archivo
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Creamos el Object output stream que usaremos para escribir objetos en el archivo
			
			oos.writeObject(mascota); // Escribimos el opbjeto en el archivo
			
			oos.flush(); // Guardamos la información en el archivo
			oos.close(); // Cerramos el object output stream
			
		} catch (Exception e) {
			e.printStackTrace(); // Si se produce un error, imprimimos el mismo
		}
		
		
	}

}
