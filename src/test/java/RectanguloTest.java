/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import modelo.RectanguloModelo;


public class RectanguloTest {

    private RectanguloModelo rectangulo;

    @BeforeEach
    void setUp() {
        // Rectángulo de prueba: vértices opuestos (10,20) y (60,80)
        rectangulo = new RectanguloModelo(10, 20, 60, 80);
    }

    @Test
    void testCalcularArea() {
        double areaEsperada = 50 * 60;   // ancho 50 * alto 60 = 3000
        assertEquals(areaEsperada, rectangulo.calcularArea(), 0.001, 
            "El área del rectángulo no se calculó correctamente");
    }

    @Test
    void testCambiarEscala() {
        rectangulo.cambiarEscala(2.0);

        assertEquals(10, rectangulo.getX1(), 0.001, "x1 debe permanecer fija");
        assertEquals(20, rectangulo.getY1(), 0.001, "y1 debe permanecer fija");
        assertEquals(110, rectangulo.getX2(), 0.001, "x2 no se escaló correctamente");
        assertEquals(140, rectangulo.getY2(), 0.001, "y2 no se escaló correctamente");
    }

    @Test
    void testContienePuntoDentro() {
        assertTrue(rectangulo.contienePunto(30, 40), "El punto debería estar dentro");
        assertTrue(rectangulo.contienePunto(10, 20), "Esquina superior izquierda debería estar dentro");
        assertTrue(rectangulo.contienePunto(60, 80), "Esquina inferior derecha debería estar dentro");
    }

    @Test
    void testContienePuntoFuera() {
        assertFalse(rectangulo.contienePunto(5, 50), "Punto fuera por izquierda");
        assertFalse(rectangulo.contienePunto(35, 10), "Punto fuera por arriba");
        assertFalse(rectangulo.contienePunto(70, 50), "Punto fuera por derecha");
    }

    @Test
    void testMoverHorizontal() {
        rectangulo.moverHorizontal(25);
        assertEquals(35, rectangulo.getX1(), 0.001);
        assertEquals(85, rectangulo.getX2(), 0.001);
    }

    @Test
    void testMoverVertical() {
        rectangulo.moverVertical(15);
        assertEquals(35, rectangulo.getY1(), 0.001);
        assertEquals(95, rectangulo.getY2(), 0.001);
    }

    @Test
    void testConstructorPorDefecto() {
        RectanguloModelo r = new RectanguloModelo();
        assertEquals(0, r.getX1(), 0.001);
        assertEquals(0, r.getY1(), 0.001);
        assertEquals(100, r.getX2(), 0.001);
        assertEquals(50, r.getY2(), 0.001);
    }
}