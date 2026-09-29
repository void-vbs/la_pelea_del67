import display.WindowManager;
import gfx.Background;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Juego implements Runnable {

    private WindowManager ventana;
    private Background fondo;
    private boolean running = false;
    private Thread thread;

    public Juego(){
        // crear la ventana
        ventana = new WindowManager("Prueba", 1920, 1080);

        // cargar la imagen del mapa
        fondo = new Background("/texturas/mapas/fondo1.jpeg");
    }

    private void render(){
        BufferStrategy bs = ventana.getCanvas().getBufferStrategy();
        if(bs == null){
            ventana.getCanvas().createBufferStrategy(3);
            return;
        }
        
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

        // Mantener los pixeles nitidos al escalar 
    g2d.setRenderingHint(
        java.awt.RenderingHints.KEY_INTERPOLATION,
        java.awt.RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
    );

        // dibujar fondo primero
        fondo.render(g2d, ventana.getAncho(), ventana.getAlto());

        //dibujar jugador (mas adelante)
        g2d.dispose();
        bs.show();
    }

    @Override 
    public void run(){
        while (running) {
            render();
            try{
                Thread.sleep(16);   // 60 fps aprox
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args){
        new Juego().start();
    }
}
