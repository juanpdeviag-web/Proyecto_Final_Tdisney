package com.techpark.model;

import java.util.ArrayList;
import java.util.List;

public class Visitante extends Persona implements INotificable {
    private static final long serialVersionUID = 1L;

    private double saldoVirtual;
    private String fotografiaUrl; // Opcional para el pase digital
    private Ticket ticket; // Ticket asociado (General, Familiar o FastPass)

    // Listas de historial y notificaciones
    private List<RegistroVisita> historialVisitas;
    private List<Notificacion> buzonNotificaciones;

    // Constructor completo
    public Visitante(String documento, String nombre, int edad, double estatura, double saldoVirtual, String fotografiaUrl) {
        super(nombre, documento, edad, estatura); // Pasa los datos a la clase abstracta Persona
        this.saldoVirtual = saldoVirtual;
        this.fotografiaUrl = fotografiaUrl;
        this.historialVisitas = new ArrayList<>();
        this.buzonNotificaciones = new ArrayList<>();
    }

    // Método obligatorio de la interfaz INotificable
    @Override
    public void recibirNotificacion(Notificacion notificacion) {
        if (notificacion != null) {
            this.buzonNotificaciones.add(notificacion);
        }
    }

    // Método para agregar una visita al historial
    public void registrarNuevaVisita(RegistroVisita visita) {
        if (visita != null) {
            this.historialVisitas.add(visita);
        }
    }

    // Métodos Getter y Setter obligatorios para la prueba de tus compañeros
    public List<Notificacion> getBuzonNotificaciones() {
        return buzonNotificaciones;
    }

    public double getSaldoVirtual() {
        return saldoVirtual;
    }

    public void setSaldoVirtual(double saldoVirtual) {
        this.saldoVirtual = saldoVirtual;
    }

    public String getFotografiaUrl() {
        return fotografiaUrl;
    }

    public void setFotografiaUrl(String fotografiaUrl) {
        this.fotografiaUrl = fotografiaUrl;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<RegistroVisita> getHistorialVisitas() {
        return historialVisitas;
    }
}
