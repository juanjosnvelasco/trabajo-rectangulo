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
import vista.RectanguloVista;;

public class Rectangulo {

    public static void main(String[] args) {

        RectanguloModelo rect = new RectanguloModelo(0, 0, 4, 5);
        RectanguloControlador controlador = new RectanguloControlador(rect);
        RectanguloVista vista = new RectanguloVista(controlador);

        vista.setVisible(true);
    }
}