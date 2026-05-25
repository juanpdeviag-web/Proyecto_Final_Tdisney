package com.techpark.control;
import com.techpark.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VisitanteNotificacionTest {

    @Test
    void testVisitanteRecibeNotificacionCorrectamente() {
        // 1. Crear un visitante con los datos base de Persona y su saldo virtual
        Visitante visitante = new Visitante("V001", "María Gómez", 20, 1.65, 50000.0, "foto_maria.png");

        // 2. Verificar que al inicio el buzón de notificaciones esté completamente vacío
        assertEquals(0, visitante.getBuzonNotificaciones().size());

        // 3. Crear una nueva notificación usando el record
        Notificacion alertaClima = new Notificacion("ALERTA CLIMÁTICA: La atracción Splash Mountain cerrará por lluvias.");

        // 4. Invocar el método de la interfaz INotificable
        visitante.recibirNotificacion(alertaClima);

        // 5. Validaciones (Asserts)
        // El tamaño del buzón ahora debe ser 1
        assertEquals(1, visitante.getBuzonNotificaciones().size());

        // El contenido del mensaje debe ser el esperado
        Notificacion notificacionRecibida = visitante.getBuzonNotificaciones().get(0);
        assertTrue(notificacionRecibida.mensaje().contains("ALERTA CLIMÁTICA"));
        assertTrue(notificacionRecibida.mensaje().contains("Splash Mountain"));
    }
}
