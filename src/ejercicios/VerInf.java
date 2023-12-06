package ejercicios;

import java.io.File; // Importamos la clase File

public class VerInf {

	public static void main(String[] args) {
		File f = new File("."); // Creamos una variable file con la ruta relativa actual
		for(File ff : f.listFiles()) { // Recorremos todos los archivos del directorio actual
			// Mostramos varios atributos de los arvhicos recuperados
			System.out.println("Nombre: " + ff.getName() + "\nRuta absoluta: " + ff.getAbsolutePath() + "\nEs ejecutable: " + ff.canExecute() + "\nEs un directorio: " + ff.isDirectory());
		}
	}

}
