package gfx;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageLoader {
     
    public static BufferedImage cargarImagen(String ruta){
        try{
            // Quitamos la barra inicial si existe para la búsqueda por ClassLoader
            String rutaSinBarra = ruta.startsWith("/") ? ruta.substring(1) : ruta;

            // Intento 1: A través del ClassLoader del hilo o de la clase
            InputStream is = ImageLoader.class.getClassLoader().getResourceAsStream(rutaSinBarra);
            
            // Intento 2: Búsqueda absoluta tradicional
            if (is == null) {
                is = ImageLoader.class.getResourceAsStream("/" + rutaSinBarra);
            }

            if (is == null) {
                System.err.println("No se encontró el archivo: " + ruta);
                return null;
            }

            // carga la imagen usando ClassLoader para compatibilidad con linux, windows, mac y dentro de .jar
            return ImageIO.read(is); 
        }
            // captura posibles errores
        catch (Exception e){                  
            System.err.println("Error al cargar la imagen en la ruta: " + ruta);
            e.printStackTrace();
            return null;
        }
    }
}
