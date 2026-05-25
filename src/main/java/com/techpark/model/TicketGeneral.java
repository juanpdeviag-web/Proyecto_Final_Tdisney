package com.techpark.model;


public class TicketGeneral extends Ticket {

    public TicketGeneral(String id, double precioBase) {
        super(id, precioBase, TipoTicket.GENERAL);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase();
    }
}