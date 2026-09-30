import display.WindowManager;
import gfx.Background;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Juego implements Runnable {

    // resolución interna base (cambie a 640x360 por ahora para que se vea mehjor)
    public static final int ANCHO_VIRTUAL = 640;
    public static final int ALTO_VIRTUAL = 360;

    private WindowManager window;
    private Background fondo;
    private BufferedImage lienzoVirtual;

    private boolean running = false;
    private Thread thread;

    public Juego() {
        // tamaño de ventana escalado (640x360 es multiplo de las resoluciones)
        window = new WindowManager("Prueba1", 1920, 1080);

        // creamos la imagen interna en memoria ram
        lienzoVirtual = new BufferedImage(ANCHO_VIRTUAL, ALTO_VIRTUAL, BufferedImage.TYPE_INT_RGB);

        // cargamos la textura del espacio (640x360)
        fondo = new Background("/texturas/mapas/espacio2.jpeg");
    }

    private void update() {
        fondo.update();
        // prolximo paso: nave.update();
    }

    private void render() {
        BufferStrategy bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }

        // ==========================================
        // PASO 1: dibujar en el lienzo virtual (640x360)
        // ==========================================
        Graphics2D gVirtual = lienzoVirtual.createGraphics();

        // dibujamos el fondo en el lienzo pequeño
        fondo.render(gVirtual);

        // mas adelante aca va nave, balas y enemigos

        gVirtual.dispose();

        // ==========================================
        // PASO 2: escalar a la ventana real sin perder nitidez
        // ==========================================
        Graphics2D gPantalla = (Graphics2D) bs.getDrawGraphics();

        // dorzar pixeles nitidos (sin difuminar)
        gPantalla.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
        );

        // proyectar el lienzo pequeño a la resolución completa de la ventana (me preoyecto w)
        gPantalla.drawImage(lienzoVirtual, 0, 0, window.getAncho(), window.getAlto(), null);

        gPantalla.dispose();
        bs.show();
    }

    @Override
    public void run() {
        while (running) {
            update();
            render();

            try {
                Thread.sleep(16); // ~60 fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        new Juego().start();
    }
}