package clasesObj;

import java.io.Serializable;

public class Mascota implements Serializable {
	
	private String nombre;
	private int edad;
	private String tipo;
	private String sexo;
	
	public Mascota(String nombre, int edad, String tipo, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.tipo = tipo;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Este " + tipo +" se llama " + nombre + ", tiene " + edad + " años, y es " + sexo;
	}
	
	
}
