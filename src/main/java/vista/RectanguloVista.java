/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author juanc
 */

import javax.swing.*;
import java.awt.*;

public class RectanguloVista extends JFrame {

    private JTextField txtX1, txtY1, txtX2, txtY2, txtFactor, txtPx, txtPy, txtUnidades;
    private JButton btnEstablecer, btnArea, btnEscala, btnPunto, btnIzq, btnDer, btnArriba, btnAbajo;
    private JLabel lblArea;
    private JPanel panelDibujo;

    private double drawX1 = 0, drawY1 = 0, drawX2 = 100, drawY2 = 50;

    public RectanguloVista() {
        setTitle("Rectángulo - MVC | juanc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 700);
        setLayout(new BorderLayout(10, 10));

        
        JPanel panelControles = new JPanel(new GridLayout(9, 2, 8, 8));

        panelControles.add(new JLabel("X1:")); 
        txtX1 = new JTextField("0"); 
        panelControles.add(txtX1);

        panelControles.add(new JLabel("Y1:")); 
        txtY1 = new JTextField("0"); 
        panelControles.add(txtY1);

        panelControles.add(new JLabel("X2:")); 
        txtX2 = new JTextField("100"); 
        panelControles.add(txtX2);

        panelControles.add(new JLabel("Y2:")); 
        txtY2 = new JTextField("50"); 
        panelControles.add(txtY2);

        panelControles.add(new JLabel("Factor Escala:")); 
        txtFactor = new JTextField("2"); 
        panelControles.add(txtFactor);

        panelControles.add(new JLabel("Punto X:")); 
        txtPx = new JTextField("50"); 
        panelControles.add(txtPx);

        panelControles.add(new JLabel("Punto Y:")); 
        txtPy = new JTextField("30"); 
        panelControles.add(txtPy);

        panelControles.add(new JLabel("Unidades movimiento:")); 
        txtUnidades = new JTextField("20"); 
        panelControles.add(txtUnidades);

        btnEstablecer = new JButton("Crear Rectángulo");
        btnArea = new JButton("Calcular Área");
        btnEscala = new JButton("Cambiar Escala");
        btnPunto = new JButton("¿Punto dentro?");
        btnIzq = new JButton("← Izquierda");
        btnDer = new JButton("Derecha →");
        btnArriba = new JButton("↑ Arriba");
        btnAbajo = new JButton("↓ Abajo");

        panelControles.add(btnEstablecer);
        panelControles.add(btnArea);
        panelControles.add(btnEscala);
        panelControles.add(btnPunto);
        panelControles.add(btnIzq);
        panelControles.add(btnDer);
        panelControles.add(btnArriba);
        panelControles.add(btnAbajo);

        add(panelControles, BorderLayout.NORTH);

        
        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());

                int minX = (int) Math.min(drawX1, drawX2);
                int minY = (int) Math.min(drawY1, drawY2);
                int w = (int) Math.abs(drawX2 - drawX1);
                int h = (int) Math.abs(drawY2 - drawY1);

                g.setColor(Color.BLUE);
                g.drawRect(minX + 80, minY + 80, w, h);

                g.setColor(Color.RED);
                g.drawString("Rectángulo", minX + 90, minY + 60);
            }
        };
        panelDibujo.setBackground(Color.LIGHT_GRAY);
        add(panelDibujo, BorderLayout.CENTER);

        lblArea = new JLabel("Área: 0.0", SwingConstants.CENTER);
        lblArea.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblArea, BorderLayout.SOUTH);
    }

    
    public void actualizarDibujo(double x1, double y1, double x2, double y2) {
        this.drawX1 = x1;
        this.drawY1 = y1;
        this.drawX2 = x2;
        this.drawY2 = y2;
        panelDibujo.repaint();
    }

    public void mostrarArea(double area) {
        lblArea.setText("Área: " + String.format("%.2f", area));
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    
    public double getX1() { return Double.parseDouble(txtX1.getText().trim()); }
    public double getY1() { return Double.parseDouble(txtY1.getText().trim()); }
    public double getX2() { return Double.parseDouble(txtX2.getText().trim()); }
    public double getY2() { return Double.parseDouble(txtY2.getText().trim()); }
    public double getFactor() { return Double.parseDouble(txtFactor.getText().trim()); }
    public double getPx() { return Double.parseDouble(txtPx.getText().trim()); }
    public double getPy() { return Double.parseDouble(txtPy.getText().trim()); }
    public double getUnidades() { return Double.parseDouble(txtUnidades.getText().trim()); }

   
    public JButton getBtnEstablecer() { return btnEstablecer; }
    public JButton getBtnArea() { return btnArea; }
    public JButton getBtnEscala() { return btnEscala; }
    public JButton getBtnPunto() { return btnPunto; }
    public JButton getBtnIzq() { return btnIzq; }
    public JButton getBtnDer() { return btnDer; }
    public JButton getBtnArriba() { return btnArriba; }
    public JButton getBtnAbajo() { return btnAbajo; }
}