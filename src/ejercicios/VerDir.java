package ejercicios;

import java.io.File; // Importamos la clase File

public class VerDir {

	public static void main(String[] args) { 
		//Creamos una variable de tipo File
		//Si le hemos pasado algún argumento al programa, utiliza ese argumento como ruta para mostrar los archivos
		//Si no, utiliza la ruta actual
		File f = args.length>=1 ? new File(args[0]) : new File("."); 
	
		if(!f.exists()) { System.out.println("La ruta especificada no existe"); } // Mostramos un mensaje de rror si la ruta especificada no exite
		for(File ff : f.listFiles()) { System.out.println(ff.getName()); } //Para cada archivo que recuperamos con el método listFiles, mostramos su nombre por pantalla
	}

}
