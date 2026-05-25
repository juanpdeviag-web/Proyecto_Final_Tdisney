package com.techpark.model;
public class TicketFamiliar extends Ticket {
    private double descuentoFamiliar; // Ejemplo: 0.15 para el 15%

    public TicketFamiliar(String id, double precioBase, double descuentoFamiliar) {
        super(id, precioBase, TipoTicket.FAMILIAR);
        this.descuentoFamiliar = descuentoFamiliar;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() * (1.0 - descuentoFamiliar);
    }

    public double getDescuentoFamiliar() {
        return descuentoFamiliar;
    }

    public void setDescuentoFamiliar(double descuentoFamiliar) {
        this.descuentoFamiliar = descuentoFamiliar;
    }
}
