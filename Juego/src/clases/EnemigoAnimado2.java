package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoAnimado2 extends Herencia{
	private String indiceImagen;
	private boolean capturado;
	public static String animacionActual;
	private HashMap<String, Animacion> animaciones;
	private int z;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;	
		
	public EnemigoAnimado2(int x, int y, int ancho, int alto, String indiceImagen, int velocidad, String animacionActual) {
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
					new Rectangle(287, 9, 55, 62),
					new Rectangle(224, 9, 59, 62),
					new Rectangle(167, 9, 57, 62),
					new Rectangle(113, 9, 51, 62),
					new Rectangle(65, 7, 43, 64),
					new Rectangle(14, 3, 39, 68),
					
					new Rectangle(302, 81, 38, 67),
					new Rectangle(245, 81, 40, 66),
					new Rectangle(178, 84, 52, 63),
					new Rectangle(114, 84, 56, 63),
					new Rectangle(62, 84, 48, 66),
					new Rectangle(6, 85, 48, 66)
					
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
			z=getX();
			setX(z-=3);
			graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				z, getY(),
				this.anchoImagen, this.altoImagen
			);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(getX(), getY(), this.anchoImagen, this.altoImagen);
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}
