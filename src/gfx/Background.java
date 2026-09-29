package gfx;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Background {
    
    private BufferedImage imagenActual;
    private double x = 0;
    private double y = 0;

    public Background(String rutaInicial){
        cambiarFondo(rutaInicial);
    }

    public void cambiarFondo(String ruta){
        this.imagenActual = ImageLoader.cargarImagen(ruta);
    }

    // metodo para mover el fondo o sincronizar con una camara
    public void setPosicion(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void render(Graphics2D g2d, int anchoPantalla, int altoPantalla){
        if (imagenActual != null){
            // dibuja la imagen en la posicion calculada con su tamano real
            g2d.drawImage(imagenActual, (int) x, (int) y, anchoPantalla, altoPantalla, null);
        }
    }

    // getters
    public int getAncho(){
        return imagenActual != null ? imagenActual.getWidth() : 0;
    }

    public int getAlto(){
        return imagenActual != null ? imagenActual.getHeight() : 0;
    }
 

}
