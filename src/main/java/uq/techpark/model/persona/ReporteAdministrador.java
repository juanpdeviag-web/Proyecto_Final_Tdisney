package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque.Parque;

import java.util.ArrayList;

public class ReporteAdministrador {

    public String generarReporteAtracciones(Parque parque) {
        String reporte = "Reporte de atracciones\n";
        ArrayList<Atraccion> atracciones = parque.obtenerTodasLasAtracciones();

        for (Atraccion atraccion : atracciones) {
            reporte = reporte + atraccion.getNombre()
                    + " - visitas: " + atraccion.getContadorVisitantes()
                    + " - estado: " + atraccion.getEstado() + "\n";
        }

        return reporte;
    }

    public String generarReporteIngresos(Parque parque) {
        return "Ingresos totales: " + parque.calcularIngresosTotales();
    }

    public String generarReporteAforo(Parque parque) {
        return "Aforo del parque: " + parque.getVisitantes().size() + "/" + parque.getAforoMaximo();
    }
}
