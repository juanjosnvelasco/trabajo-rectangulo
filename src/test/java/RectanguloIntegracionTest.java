/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */




/*
 * Test de Integración del sistema completo (MVC)
 * @author juanc
 */

import modelo.RectanguloModelo;
import controlador.RectanguloControlador;
import vista.RectanguloVista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de Integración que verifica que Modelo, Vista y Controlador funcionen juntos
 */
public class RectanguloIntegracionTest {

    private RectanguloModelo modelo;
    private RectanguloVista vista;
    private RectanguloControlador controlador;

    @BeforeEach
    void setUp() {
        modelo = new RectanguloModelo(0, 0, 100, 50);
        vista = new RectanguloVista();
        controlador = new RectanguloControlador(modelo, vista);
    }

    @Test
    void testIntegracionFlujoCompleto() {
        // Verificar estado inicial
        assertEquals(5000.0, modelo.calcularArea(), 0.001, "Área inicial incorrecta");

        // Probar cambio de escala (manteniendo primera coordenada fija)
        modelo.cambiarEscala(2.0);
        assertEquals(20000.0, modelo.calcularArea(), 0.001, "Área después de escalar no es correcta");
        assertEquals(0, modelo.getX1(), 0.001, "x1 debe permanecer fija después de escalar");
        assertEquals(0, modelo.getY1(), 0.001, "y1 debe permanecer fija después de escalar");

        // Probar movimiento horizontal
        modelo.moverHorizontal(30);
        assertEquals(30, modelo.getX1(), 0.001);
        assertEquals(130, modelo.getX2(), 0.001);

        // Probar movimiento vertical
        modelo.moverVertical(20);
        assertEquals(20, modelo.getY1(), 0.001);
        assertEquals(70, modelo.getY2(), 0.001);

        // Probar punto dentro del rectángulo después de los cambios
        assertTrue(modelo.contienePunto(50, 30), "Punto debería estar dentro después de movimientos");
        assertFalse(modelo.contienePunto(150, 100), "Punto debería estar fuera");

        System.out.println("✅ Test de Integración completado exitosamente");
    }

    @Test
    void testIntegracionEscalaYMovimientoCombinados() {
        modelo = new RectanguloModelo(10, 10, 40, 30);  // nuevo rectángulo

        // Escalar primero
        modelo.cambiarEscala(2.5);
        assertEquals(10, modelo.getX1(), 0.001);   // x1 fija
        assertEquals(10, modelo.getY1(), 0.001);   // y1 fija

        // Luego mover
        modelo.moverHorizontal(15);
        modelo.moverVertical(-5);

        // Verificar resultado final
        assertEquals(25, modelo.getX1(), 0.001);
        assertEquals(85, modelo.getX2(), 0.001);   // (10 + (40-10)*2.5) + 15
        assertEquals(5, modelo.getY1(), 0.001);
        assertEquals(55, modelo.getY2(), 0.001);

        double areaFinal = modelo.calcularArea();
        assertEquals(1800.0, areaFinal, 0.001, "Área final después de escala y movimiento incorrecta");
    }

    @Test
    void testIntegracionContienePuntoDespuesDeCambios() {
        modelo.cambiarEscala(1.5);
        modelo.moverHorizontal(50);
        modelo.moverVertical(30);

        assertTrue(modelo.contienePunto(80, 60));
        assertTrue(modelo.contienePunto(50, 30));   // esquina original movida
        assertFalse(modelo.contienePunto(0, 0));
    }
}