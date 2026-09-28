package gfx;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
     
    public static BufferedImage cargarImagen(String ruta){
        try{
            // carga la imagen usando ClassLoader para compatibilidad con linux, windows, mac y dentro de .jar
            return ImageIO.read(ImageLoader.class.getResourceAsStream(ruta)); 
        }
            // captura posibles errores
        catch (IOException | IllegalArgumentException e){                  
            System.err.println("Error al cargar la imagen en la ruta: " + ruta);
            e.printStackTrace();
            return null;
        }
    }
}
