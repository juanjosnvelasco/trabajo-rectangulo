/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rectangulo;

/**
 *
 * @author juanc
 */

import modelo.RectanguloModelo;
import controlador.RectanguloControlador;
import vista.RectanguloVista;

public class Rectangulo {
    public static void main(String[] args) {
        RectanguloModelo modelo = new RectanguloModelo();
        RectanguloVista vista = new RectanguloVista();
        new RectanguloControlador(modelo, vista);
        vista.setVisible(true);
    }
}