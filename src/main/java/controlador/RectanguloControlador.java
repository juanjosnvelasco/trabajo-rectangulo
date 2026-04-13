/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author juanc
 */
public class RectanguloControlador {

    private Rectangulo modelo;

    public RectanguloControlador(Rectangulo modelo) {
        this.modelo = modelo;
    }

    public double obtenerArea() {
        return modelo.area();
    }

    public void escalar(double factor) {
        modelo.escalar(factor);
    }

    public void moverX(double dx) {
        modelo.moverX(dx);
    }

    public void moverY(double dy) {
        modelo.moverY(dy);
    }

    public boolean contiene(double x, double y) {
        return modelo.contiene(x, y);
    }
}