package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.util;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque.Parque;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque.Zona;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.Administrador;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.Operador;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.Visitante;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket.Ticket;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket.TicketFastPass;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.ReporteAdministrador;

public class EjemploUso {
    public static void main(String[] args) {
        Parque parque = new Parque("TDisney", 1000);

        Administrador administrador = new Administrador(
                "Nicolas", "123", "admin@correo.com", 19,
                "A1", "admin", "1234"
        );

        Zona zonaAventura = administrador.crearZona("Zona Aventura", 300);
        Atraccion montana = administrador.crearAtraccionMecanicaAlta("AT1", "Montaña Rusa", 20, 1.40, 12);
        Atraccion carrusel = administrador.crearAtraccionGeneral("AT2", "Carrusel", 25, 0.90, 3);

        administrador.agregarAtraccionAZona(zonaAventura, montana);
        administrador.agregarAtraccionAZona(zonaAventura, carrusel);
        administrador.agregarZonaAlParque(parque, zonaAventura);

        Operador operador = new Operador(
                "Juan", "456", "operador@correo.com", 20,
                "O1", "operador", "1234"
        );

        administrador.asignarOperadorAZona(operador, zonaAventura);

        Visitante visitante = new Visitante("Carlos", "789", "carlos@correo.com", 15, 1.70, 150000);
        Ticket ticket = new TicketFastPass("T1", 80000, "22/05/2026");
        visitante.comprarTicket(ticket);
        parque.registrarVisitante(visitante);

        operador.registrarIngreso(visitante, montana);
        administrador.activarAlertaClima(parque);

        ReporteAdministrador reporte = new ReporteAdministrador();
        System.out.println(reporte.generarReporteAtracciones(parque));
        System.out.println(reporte.generarReporteIngresos(parque));
        System.out.println(reporte.generarReporteAforo(parque));
    }
}
