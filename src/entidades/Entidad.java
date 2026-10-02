package entidades;

import java.awt.Graphics2D;

public abstract class Entidad {

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
