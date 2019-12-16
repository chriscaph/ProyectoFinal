package clases;

public class Herencia {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private static int velocidad;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public static void setVelocidad(int _velocidad) {
		velocidad = _velocidad;
	}
	
	public Herencia(int x, int y, int ancho, int alto, int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
	}
	
	public Herencia() {}
}
