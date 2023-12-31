package ejercicios;

import clasesObj.Mascota;
import clasesObj.Partida;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 * Este programa funciona como el juego del Ahorcado.
 * Escoge una palabra aleatoria de un diccionario de palabras español y tienes que adivinarla.
 * El jugador tiene 10 vidas (intentos).
 * 
 * La partida se va guardando en cada turno para poder recuperar la partida en curso en caso de que se cierre el programa.
 * También se guarda un historial de partidas en un archivo.
 * 
 * El programa solo permite jugar una única partida, al perder las vidas o adivinar la palabra, se termina el juego y programa.
 * @author andres
 *
 */
public class Juego {

	static Partida partida;
	
	public static void main(String[] args) {
		// Recuperamos la partida guardada en el archivo de guardado
		// Si esa partida tiene 0 vidas, crearemos una partida nueva
		partida = recuperarPartida();
		
		// Este es el bucle de juego
		while(partida.getVidas()>0) {
			
			partida.introduceLetra(leerLetra());
			
			// En cada turno imprimimos el estado de la partida mediante la función toString() de la clase Partida
			System.out.println(partida);
			
			// Comprobamos si el jugador ha adivinado todas las letras
			finPartida();
			
			// Guardamos la partida cada turno
			guardarPartida();
		}
		historial(false);
		
		System.out.println("Se ha acabado la partida");
	}
	
	// Recuperamos la partida guardada
	public static Partida recuperarPartida() {
		File f = new File("./src/archivosEjemplo/partidaGuardada");
		try {
			
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Partida p = (Partida) ois.readObject();
			
			fis.close();
			ois.close();
			
			// Comprobamos si la partida recuperada todavía tiene alguna vida o si ya se ha terminado
			if(p.getVidas()>0) {
				System.out.println("Se ha recuperado una partida en curso");
				System.out.println(p.toString());
				return p;
			} else {
				System.out.println("Nueva partida!");
				return iniciarPartida();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iniciarPartida();
	}
	
	// Guardamos el resultado de la partida en el archivo historial
	// El boolean modifica si se guarda como victoria (true) o derrota (false)
	public static void historial(boolean ganado) {
		File f = new File("./src/archivosEjemplo/historialPartidas.txt");
		if(ganado) {
			try {
				FileWriter fw = new FileWriter(f, true);
				String cadena = "VICTORIA - La palabra era: " + partida.getPalabra() + "\n"; 
				fw.write(cadena);
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		} else {
			try {
				FileWriter fw = new FileWriter(f, true);
				String cadena = "DERROTA - La palabra era: " + partida.getPalabra() + "\n"; 
				fw.write(cadena);
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		}
	}
	
	// Guardamos la partida
	public static void guardarPartida() {
		File f = new File("./src/archivosEjemplo/partidaGuardada");
	
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(partida);
			oos.flush(); 
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// Comprobamos si el usuario ha ganado la partida
	public static void finPartida() {
		boolean terminado = true;
		for(boolean b : partida.getAcertadas()) { 
			if(!b) { 
				terminado = false;
			}
			
		}
		if(terminado) {
			System.out.println("Felicidades, has ganado!");
			
			historial(true);
			
			// Cambiamos las vidas a 0 después de mostrar el mensaje de victoria
			// Esto hace que cuando se vuelva a iniciar el programa se cree una nueva partida
			partida.setVidas(0);
			
			// Guardamos la partida con 0 vidas
			guardarPartida();
			System.exit(0);
		}
		
	}
	
	// Creamos una nueva partida
	public static Partida iniciarPartida()  {
		File f = new File("./src/archivosEjemplo/diccionario.txt");
		Path p = Paths.get(f.getAbsolutePath());
		
		try {
			List<String> palabras = Files.readAllLines(p);
			
			// Escogemos una palabra aleatoria del diccionario de palabras
			String palabra = palabras.get((int)(Math.random()*palabras.size()));
			
			return new Partida(palabra);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0); // Si sucede algún error iniciando la partida cerramos el programa
			return null; 
		}
	}
	
	// Leemos el input del usuario con una pequeña validación por si introduce varias letras o un caracter no válido
	// En caso de que el usuario haya introducido varias letras, únicamente se usa la primera
	public static char leerLetra() {
		System.out.println("Introduce una letra: ");
		Scanner sc = new Scanner(System.in); // Creamos un escaner para el input por teclado
		char letra = ' ';
		do {
			String input = sc.next();
			try {
				letra = input.toLowerCase().charAt(0); // Únicamente cogemos la primera letra
				System.out.println(letra);
				return letra;
			} catch (Exception e) {
			}
		} while(inputValido(letra));
		sc.close(); // El escaner lo cerramos aquí porque si lo cerrasemos en el bucle daría excepción
		return letra;
	}
	
	// Hacemos la comprobación de si el caracter es una letra válida
	// Esto lo hacemos comprobando vs una cadena del abecedario completo
	public static boolean inputValido(char letra) {
		String abc = "abcdefghijklmnñopqrstuvwxyz";
		for(int i = 0; i<abc.length(); i++) {
			if(abc.charAt(i)==letra) {
				return true;
			}
		}
		return false;
	}
	
	

}
