package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.util.INotificable;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket.Ticket;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket.TipoTicket;

import java.util.ArrayList;

public class Visitante extends Persona implements INotificable {
    private double estatura;
    private double saldoVirtual;
    private Ticket ticket;
    private ArrayList<Atraccion> atraccionesFavoritas;
    private ArrayList<String> historialVisitas;
    private ArrayList<Notificacion> notificaciones;

    public Visitante(String nombre, String documento, String correo, int edad,
                     double estatura, double saldoVirtual) {
        super(nombre, documento, correo, edad);
        this.estatura = estatura;
        this.saldoVirtual = saldoVirtual;
        this.atraccionesFavoritas = new ArrayList<>();
        this.historialVisitas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public boolean comprarTicket(Ticket ticket) {
        if (ticket == null) {
            return false;
        }

        double precio = ticket.calcularPrecioFinal();

        if (saldoVirtual >= precio) {
            saldoVirtual = saldoVirtual - precio;
            this.ticket = ticket;
            return true;
        }

        return false;
    }

    public double consultarSaldo() {
        return saldoVirtual;
    }

    public void recargarSaldo(double monto) {
        if (monto > 0) {
            saldoVirtual = saldoVirtual + monto;
        }
    }

    public void agregarAtraccionFavorita(Atraccion atraccion) {
        if (atraccion != null) {
            atraccionesFavoritas.add(atraccion);
        }
    }

    public void registrarVisita(Atraccion atraccion) {
        if (atraccion != null) {
            historialVisitas.add(atraccion.getNombre());
        }
    }

    public boolean tieneTicket() {
        return ticket != null;
    }

    public boolean tieneFastPass() {
        return ticket != null && ticket.getTipo() == TipoTicket.FAST_PASS;
    }

    @Override
    public void recibirNotificacion(String mensaje) {
        Notificacion notificacion = new Notificacion(mensaje, getNombre());
        notificaciones.add(notificacion);
    }

    @Override
    public String getTipoPersona() {
        return "Visitante";
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getSaldoVirtual() {
        return saldoVirtual;
    }

    public void setSaldoVirtual(double saldoVirtual) {
        this.saldoVirtual = saldoVirtual;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Atraccion> getAtraccionesFavoritas() {
        return atraccionesFavoritas;
    }

    public ArrayList<String> getHistorialVisitas() {
        return historialVisitas;
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }
}
