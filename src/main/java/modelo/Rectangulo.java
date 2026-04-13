/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanc
 */
public class Rectangulo extends Figura {

    private double x1, y1, x2, y2;

    public Rectangulo(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public double area() {
        return Math.abs((x2 - x1) * (y2 - y1));
    }

    public void escalar(double factor) {
        this.x2 = x1 + (x2 - x1) * factor;
        this.y2 = y1 + (y2 - y1) * factor;
    }

    public boolean contiene(double x, double y) {
        return x >= Math.min(x1, x2) && x <= Math.max(x1, x2)
            && y >= Math.min(y1, y2) && y <= Math.max(y1, y2);
    }

    
    public void mover(double dx, double dy) {
        this.x1 += dx;
        this.x2 += dx;
        this.y1 += dy;
        this.y2 += dy;
    }

    public void moverX(double dx) {
        mover(dx, 0);
    }

    public void moverY(double dy) {
        mover(0, dy);
    }
}