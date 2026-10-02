package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    private boolean[] teclas = new boolean[256];
    
    public boolean arriba, abajo, izquierda, derecha, disparo;

    public void update(){
        arriba = teclas[KeyEvent.VK_W] || teclas[KeyEvent.VK_UP];
        abajo = teclas[KeyEvent.VK_S] || teclas[KeyEvent.VK_DOWN];
        izquierda = teclas[KeyEvent.VK_A] || teclas[KeyEvent.VK_LEFT];
        derecha = teclas[KeyEvent.VK_D] || teclas[KeyEvent.VK_RIGHT];
        disparo = teclas[KeyEvent.VK_SPACE];
    }

    @Override 
    public void keyPressed(KeyEvent tecla){
        if (tecla.getKeyCode() < teclas.length){
            teclas[tecla.getKeyCode()] = true;
        }
    }

    @Override 
    public void keyReleased(KeyEvent tecla){
        if (tecla.getKeyCode() < teclas.length){
            teclas[tecla.getKeyCode()] = false;
        }
    }

     @Override 
     public void keyTyped(KeyEvent tecla){}

}
