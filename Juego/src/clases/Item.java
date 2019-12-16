package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item extends Herencia{
	private String indiceImagen;
	private boolean capturado;
	public Item(int x, int y, int ancho, int alto, String indiceImagen, int velocidad) {
		super(x,y,ancho,alto,velocidad);
		this.indiceImagen = indiceImagen;
	}

	public void mover(){
		if (Juego.derecha)
			setX(getX()-getVelocidad());
	}
	
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(Juego.imagenes.get(indiceImagen), getX(), getY());
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(getX(),getY(), 18, 18);
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}
