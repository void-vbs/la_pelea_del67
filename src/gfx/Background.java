package gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Background {

    private BufferedImage imagen;
    private double y1;
    private double y2;
    private double velocidad = 0.4; // velocidad del scroll de estrellas

    public Background(String rutaInicial) {
        cambiarFondo(rutaInicial);
        this.y1 = 0;
        // la segunda imagen se coloca justo encima de la primera
        this.y2 = -360;
    }

    public void cambiarFondo(String ruta) {
        this.imagen = ImageLoader.cargarImagen(ruta);
    }

    public void update() {
        // mover hacia abajo
        y1 += velocidad;
        y2 += velocidad;

        // si la primera imagen sale por la parte inferior, vuelve arriba
        if (y1 >= 360) {
            y1 = y2 - 360;
        }

        // si la segunda imagen sale por la parte inferior, vuelve arriba
        if (y2 >= 360) {
            y2 = y1 - 360;
        }
    }

    // renderizamos siempre sobre la resolución fija interna (320x180)
    public void render(Graphics2D g2d) {
        if (imagen != null) {
            g2d.drawImage(imagen, 0, (int) y1, 640, 360, null);
            g2d.drawImage(imagen, 0, (int) y2, 640, 360, null);
        }
    }
}