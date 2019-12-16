package clases;

import java.io.Serializable;

public class Jugador implements Serializable{
	private static String nombre;
	private static int puntuacion;
	
	public Jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	public Jugador() {}
	
	public static String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public static String toCSV() {
		return getNombre()+","+getPuntuacion()+"\n";
	}
}
