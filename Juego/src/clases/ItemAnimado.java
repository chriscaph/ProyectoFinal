package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class ItemAnimado extends Herencia{
	private String indiceImagen;
	private boolean capturado;
	public static String animacionActual;
	private HashMap<String, Animacion> animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;	
		
	public ItemAnimado(int x, int y, int ancho, int alto, String indiceImagen, int velocidad, String animacionActual) {
		super(x,y,ancho,alto,velocidad);
		this.indiceImagen = indiceImagen;
		this.capturado = capturado;
		this.animacionActual=animacionActual;
		inicializarAnimaciones();
	}

	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasMover[]= {
					new Rectangle(11, 12, 37, 37),
					new Rectangle(50, 12, 37, 37),
					new Rectangle(92, 12, 37, 37),
					new Rectangle(7, 56, 37, 37),
					new Rectangle(43, 56, 37, 37),
					new Rectangle(94, 56, 37, 37)
			};
			
			Animacion animacionMover = new Animacion("mover",coordenadasMover,0.1);
			animaciones.put("mover",animacionMover);
	}
	
	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public void mover(){
		if (Juego.derecha)
			setX(getX()-getVelocidad());
	}
	
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(
					Juego.imagenes.get(this.indiceImagen), 
					this.xImagen, this.yImagen, 
					this.anchoImagen, this.altoImagen,
					getX(), getY(),
					this.anchoImagen, this.altoImagen
			);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(getX(),getY(), this.anchoImagen, this.altoImagen);
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}
