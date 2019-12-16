package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoAnimado1 extends Herencia{
	private String indiceImagen;
	private boolean capturado;
	public static String animacionActual;
	private HashMap<String, Animacion> animaciones;
	private int z;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;	
		
	public EnemigoAnimado1(int x, int y, int ancho, int alto, String indiceImagen, int velocidad, String animacionActual) {
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
					new Rectangle(298, 6, 59, 65),
					new Rectangle(238, 6, 60, 66),
					new Rectangle(179, 6, 59, 66),
					new Rectangle(120, 6, 59, 66),
					new Rectangle(62, 6, 58, 66),
					new Rectangle(5, 6, 57, 66),
					
					new Rectangle(303, 77, 56, 65),
					new Rectangle(240, 78, 57, 66),
					new Rectangle(180, 79, 57, 67),
					new Rectangle(118, 78, 58, 66),
					new Rectangle(59, 78, 59, 66),
					new Rectangle(0, 78, 59, 66),
					
					new Rectangle(297, 146, 61, 66),
					new Rectangle(236, 146, 61, 66),
					new Rectangle(176, 146, 61, 66),
					new Rectangle(119, 146, 58, 66),
					new Rectangle(61, 146, 57, 66),
					new Rectangle(1, 146, 60, 66)
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
			setX(z-=2);
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
