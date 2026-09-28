package display;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class WindowManager {
    
    // declaramos los atributos
    private JFrame frame;
    private Canvas canvas;
    private int alto;
    private int ancho;

    // constructor que recibe titulo, ancho y alto para crear la ventana
    public WindowManager(String titulo, int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;

        crearVentana(titulo);

    }

    public void crearVentana(String titulo){
        frame = new JFrame(titulo);
        frame.setSize(ancho, alto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // mata el proceso al presionar la x
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);                      // centra la ventana

        // lienzo dobde se va a dibujar el juego
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(ancho, alto));    // Dimension empaqueta ancho y altura para pasar un solo parametro  
        canvas.setMinimumSize(new Dimension(ancho, alto)); 
        canvas.setMaximumSize(new Dimension(ancho, alto)); 
        canvas.setFocusable(false);                             // evita que el lienzo capture el input del teclado, dejando libre el input para JFrame

        // anadimos el canvas al frame y empaquetamos
        frame.add(canvas);
        frame.pack();                                           // empaquueta los bordes de la ventana para mejor compatibilidad con todos los OS

        frame.setVisible(true);
    }

    // getters
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAlto(){
        return alto;
    }
}
