package entidades;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entidad {

    // toggle de la hitbox
    public static boolean HITBOX = false;

    protected double x,y;
    protected int ancho, alto;
    protected double velocidad;

    public Entidad(double x, double y, int ancho, int alto, double velocidad){
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.velocidad = velocidad;
    }

    public abstract void update();
    public abstract void render(Graphics2D g2d);

    // caja de colision por default
    public Rectangle getLimites(){
        return new Rectangle((int) x, (int) y, ancho, alto);
    }            

    // metodo auxiliar para dibujar la hitbox
    protected void renderHitbox(Graphics2D g2d){
        if(HITBOX){
            g2d.setColor(Color.BLUE);
            g2d.drawRect((int) x, (int) y, ancho, alto);
        }
    }

    // getters
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAlto(){
        return alto;
    }

    public double getVelocidad(){
        return velocidad;
    }

    // setters
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    public void setAncho(int ancho){this.ancho = ancho;}
    public void setAlto(int alto){this.alto = alto;};
    public void setVelocidad(double velocidad){this.velocidad = velocidad;}
}
