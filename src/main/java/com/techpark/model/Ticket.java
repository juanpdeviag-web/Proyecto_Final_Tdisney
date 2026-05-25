package com.techpark.model;
import java.io.Serializable;

public abstract class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private double precioBase;
    private TipoTicket tipo;

    // Constructor completo
    public Ticket(String id, double precioBase, TipoTicket tipo) {
        this.id = id;
        this.precioBase = precioBase;
        this.tipo = tipo;
    }

    // Método abstracto cada tipo de ticket calculará su precio final de forma diferente
    public abstract double calcularPrecioFinal();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public TipoTicket getTipo() {
        return tipo;
    }

    public void setTipo(TipoTicket tipo) {
        this.tipo = tipo;
    }
}
