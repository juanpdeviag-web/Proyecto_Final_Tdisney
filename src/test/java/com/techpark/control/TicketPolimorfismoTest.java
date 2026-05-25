package com.techpark.control;
import com.techpark.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicketPolimorfismoTest {

    @Test
    void testCalcularPrecioFinalTicketGeneral() {
        // Un ticket general de 50.000 COP no debería sufrir modificaciones
        Ticket ticketGeneral = new TicketGeneral("TCK-GEN-01", 50000.0);

        assertEquals(50000.0, ticketGeneral.calcularPrecioFinal(), 0.01);
    }

    @Test
    void testCalcularPrecioFinalTicketFamiliarConDescuento() {
        // Un ticket familiar de 100.000 COP con 15% de descuento (0.15) debe dar 85.000 COP
        Ticket ticketFamiliar = new TicketFamiliar("TCK-FAM-01", 100000.0, 0.15);

        double precioEsperado = 100000.0 * (1.0 - 0.15); // 85000.0
        assertEquals(precioEsperado, ticketFamiliar.calcularPrecioFinal(), 0.01);
    }

    @Test
    void testCalcularPrecioFinalTicketFastPassConCargoAdicional() {
        // Un ticket FastPass de 60.000 COP con un cargo extra de 25.000 COP debe dar 85.000 COP
        Ticket ticketFastPass = new TicketFastPass("TCK-FAST-01", 60000.0, 25000.0);

        double precioEsperado = 60000.0 + 25000.0; // 85000.0
        assertEquals(precioEsperado, ticketFastPass.calcularPrecioFinal(), 0.01);
    }
}
