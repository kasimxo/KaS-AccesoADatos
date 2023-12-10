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


public class Juego {

	static Partida partida;
	
	public static void main(String[] args) {
		partida = recuperarPartida();
		
		while(partida.getVidas()>0) {
			partida.introduceLetra(leerLetra());
			System.out.println(partida);
			finPartida();
			guardarPartida();
		}
		historial(false);
		System.out.println("Se ha acabado la partida");

	}
	
	public static Partida recuperarPartida() {
		File f = new File("./src/archivosEjemplo/partidaGuardada");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Partida p = (Partida) ois.readObject();
			if(p.getVidas()>0) {
				return p;
			} else {
				return iniciarPartida();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iniciarPartida();
	}
	
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
			System.exit(0);
		}
		
	}
	
	public static Partida iniciarPartida()  {
		File f = new File("./src/archivosEjemplo/diccionario.txt");
		Path p = Paths.get(f.getAbsolutePath());
		
		try {
			List<String> palabras = Files.readAllLines(p);
			String palabra = palabras.get((int)(Math.random()*palabras.size()));
			return new Partida(palabra);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static char leerLetra() {
		System.out.println("Introduce una letra: ");
		Scanner sc = new Scanner(System.in);
		char letra = ' ';
		do {
			String input = sc.next();
			try {
				letra = input.toLowerCase().charAt(0);
				System.out.println(letra);
				return letra;
			} catch (Exception e) {
			}
		} while(inputValido(letra));
		sc.close();
		return letra;
	}
	
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
