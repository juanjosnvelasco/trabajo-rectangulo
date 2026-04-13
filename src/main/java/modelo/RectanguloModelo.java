/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanc
 */
public class RectanguloModelo extends Figura {

    private double x1, y1, x2, y2;

    public RectanguloModelo() {
        this(0, 0, 100, 50);
    }

    public RectanguloModelo(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public double calcularArea() {
        return Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }

    public void cambiarEscala(double factor) {
        if (factor > 0) {
            x2 = x1 + (x2 - x1) * factor;  // Primera coordenada fija
            y2 = y1 + (y2 - y1) * factor;
        }
    }

    public boolean contienePunto(double px, double py) {
        double minX = Math.min(x1, x2);
        double maxX = Math.max(x1, x2);
        double minY = Math.min(y1, y2);
        double maxY = Math.max(y1, y2);
        return px >= minX && px <= maxX && py >= minY && py <= maxY;
    }

    public void moverHorizontal(double dx) {
        x1 += dx;
        x2 += dx;
    }

    public void moverVertical(double dy) {
        y1 += dy;
        y2 += dy;
    }

    // Getters
    public double getX1() { return x1; }
    public double getY1() { return y1; }
    public double getX2() { return x2; }
    public double getY2() { return y2; }
}