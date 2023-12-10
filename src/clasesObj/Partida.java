package clasesObj;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Partida implements Serializable {

	String palabra;
	int vidas;
	boolean[] acertadas;
	List<Character> inputs;
	
	public Partida(String palabra) {
		this.palabra = palabra;
		this.vidas = 10;
		inputs = new ArrayList<Character>();
		acertadas = new boolean[palabra.length()];
		for(boolean b : acertadas) {b = false;};
	}
	
	public void introduceLetra(char letra) {
		inputs.add(letra);
		boolean acertado = false;
		for(int i = 0; i<palabra.length(); i++) {
			if(palabra.charAt(i)==letra) {
				acertadas[i] = true;
				acertado = true;
			}
		}
		if(!acertado) {
			vidas--;
		}
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public boolean[] getAcertadas() {
		return acertadas;
	}

	public void setAcertadas(boolean[] acertadas) {
		this.acertadas = acertadas;
	}

	public List<Character> getInputs() {
		return inputs;
	}

	public void setInputs(List<Character> inputs) {
		this.inputs = inputs;
	}

	@Override
	public String toString() {
		
		String output = "";
		
		for(int i = 0; i<acertadas.length; i++) {
			if(acertadas[i]) {
				output += palabra.charAt(i) + " ";
			} else {
				output += "_ ";
			}
		}
		output += "\nVidas: " + vidas;
		return output;
	}
	
	
	
}
