package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoAnimado3 extends Herencia{
	private String indiceImagen;
	private boolean capturado;
	public static String animacionActual;
	private HashMap<String, Animacion> animaciones;
	private int z;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;	
		
	public EnemigoAnimado3(int x, int y, int ancho, int alto, String indiceImagen, int velocidad, String animacionActual) {
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
					new Rectangle(287, 23, 42, 64),
					new Rectangle(230, 23, 44, 63),
					new Rectangle(174, 23, 47, 63),
					new Rectangle(121, 24, 46, 62),
					new Rectangle(71, 24, 43, 62),
					new Rectangle(28, 24, 39, 63),
					
					new Rectangle(286, 95, 40, 63),
					new Rectangle(232, 94, 40, 63),
					new Rectangle(176, 93, 45, 64),
					new Rectangle(126, 92, 43, 64),
					new Rectangle(73, 92, 42, 66),
					new Rectangle(26, 93, 41, 66)
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
			setX(z-=4);
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
