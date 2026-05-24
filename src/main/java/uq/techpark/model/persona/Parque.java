package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.EstadoAtraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.Visitante;

import java.util.ArrayList;

public class Parque {
    private String nombre;
    private int aforoMaximo;
    private boolean alertaClima;
    private ArrayList<Zona> zonas;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, int aforoMaximo) {
        this.nombre = nombre;
        this.aforoMaximo = aforoMaximo;
        this.alertaClima = false;
        this.zonas = new ArrayList<>();
        this.visitantes = new ArrayList<>();
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

    public boolean registrarVisitante(Visitante visitante) {
        if (hayCupo()) {
            visitantes.add(visitante);
            return true;
        }

        return false;
    }

    public boolean hayCupo() {
        return visitantes.size() < aforoMaximo;
    }

    public void activarAlertaClima() {
        alertaClima = true;
        cerrarAtraccionesPorClima();
        notificarVisitantes("Hay alerta climática. Algunas atracciones fueron cerradas.");
    }

    public void desactivarAlertaClima() {
        alertaClima = false;

        for (Atraccion atraccion : obtenerTodasLasAtracciones()) {
            if (atraccion.getEstado() == EstadoAtraccion.CERRADA) {
                atraccion.setEstado(EstadoAtraccion.ACTIVA);
            }
        }

        notificarVisitantes("La alerta climática terminó.");
    }

    public void cerrarAtraccionesPorClima() {
        for (Atraccion atraccion : obtenerTodasLasAtracciones()) {
            if (atraccion.cerrarPorClima()) {
                atraccion.setEstado(EstadoAtraccion.CERRADA);
            }
        }
    }

    public ArrayList<Atraccion> obtenerTodasLasAtracciones() {
        ArrayList<Atraccion> lista = new ArrayList<>();

        for (Zona zona : zonas) {
            for (Atraccion atraccion : zona.getAtracciones()) {
                lista.add(atraccion);
            }
        }

        return lista;
    }

    public void notificarVisitantes(String mensaje) {
        for (Visitante visitante : visitantes) {
            visitante.recibirNotificacion(mensaje);
        }
    }

    public double calcularIngresosTotales() {
        double total = 0;

        for (Visitante visitante : visitantes) {
            if (visitante.getTicket() != null) {
                total = total + visitante.getTicket().calcularPrecioFinal();
            }
        }

        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public boolean isAlertaClima() {
        return alertaClima;
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public ArrayList<Visitante> getVisitantes() {
        return visitantes;
    }
}
