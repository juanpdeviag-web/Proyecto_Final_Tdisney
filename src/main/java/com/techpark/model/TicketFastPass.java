package com.techpark.model;


public class TicketFastPass extends Ticket {
    private double cargoAdicional;

    public TicketFastPass(String id, double precioBase, double cargoAdicional) {
        super(id, precioBase, TipoTicket.FAST_PASS);
        this.cargoAdicional = cargoAdicional;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + cargoAdicional;
    }

    public double getCargoAdicional() {
        return cargoAdicional;
    }

    public void setCargoAdicional(double cargoAdicional) {
        this.cargoAdicional = cargoAdicional;
    }
}
