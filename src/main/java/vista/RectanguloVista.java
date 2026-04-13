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
import controlador.RectanguloControlador;  // 

public class RectanguloVista extends JFrame {

    public RectanguloVista(RectanguloControlador controlador) {

        setTitle("Rectángulo");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnArea = new JButton("Calcular Área");
        btnArea.setBounds(50, 50, 180, 30);

        btnArea.addActionListener(e -> {
            double area = controlador.obtenerArea();
            JOptionPane.showMessageDialog(this, "Área: " + area);
        });

        add(btnArea);
    }
}