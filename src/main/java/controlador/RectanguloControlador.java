/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author juanc
 */

import modelo.RectanguloModelo;
import vista.RectanguloVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectanguloControlador implements ActionListener {

    private RectanguloModelo modelo;
    private final RectanguloVista vista;

    public RectanguloControlador(RectanguloModelo modelo, RectanguloVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        
        vista.getBtnEstablecer().addActionListener(this);
        vista.getBtnArea().addActionListener(this);
        vista.getBtnEscala().addActionListener(this);
        vista.getBtnPunto().addActionListener(this);
        vista.getBtnIzq().addActionListener(this);
        vista.getBtnDer().addActionListener(this);
        vista.getBtnArriba().addActionListener(this);
        vista.getBtnAbajo().addActionListener(this);

        actualizarVista();
    }

    private void actualizarVista() {
        vista.actualizarDibujo(modelo.getX1(), modelo.getY1(), modelo.getX2(), modelo.getY2());
        vista.mostrarArea(modelo.calcularArea());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == vista.getBtnEstablecer()) {
                modelo = new RectanguloModelo(vista.getX1(), vista.getY1(), vista.getX2(), vista.getY2());
            } 
            else if (e.getSource() == vista.getBtnEscala()) {
                modelo.cambiarEscala(vista.getFactor());
            } 
            else if (e.getSource() == vista.getBtnPunto()) {
                boolean dentro = modelo.contienePunto(vista.getPx(), vista.getPy());
                vista.mostrarMensaje(dentro ? "✅ El punto ESTÁ dentro del rectángulo" : "❌ El punto está FUERA del rectángulo");
                return;
            } 
            else if (e.getSource() == vista.getBtnIzq()) {
                modelo.moverHorizontal(-vista.getUnidades());
            } 
            else if (e.getSource() == vista.getBtnDer()) {
                modelo.moverHorizontal(vista.getUnidades());
            } 
            else if (e.getSource() == vista.getBtnArriba()) {
                modelo.moverVertical(-vista.getUnidades());
            } 
            else if (e.getSource() == vista.getBtnAbajo()) {
                modelo.moverVertical(vista.getUnidades());
            }

            actualizarVista();

        } catch (Exception ex) {
            vista.mostrarMensaje("⚠️ Error: Ingresa solo números válidos en todos los campos.");
        }
    }
}