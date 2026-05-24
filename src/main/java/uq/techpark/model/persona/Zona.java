package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.Operador;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;

import java.util.ArrayList;

public class Zona {
    private String nombre;
    private int aforoMaximo;
    private ArrayList<Atraccion> atracciones;
    private ArrayList<Operador> operadores;

    public Zona(String nombre, int aforoMaximo) {
        this.nombre = nombre;
        this.aforoMaximo = aforoMaximo;
        this.atracciones = new ArrayList<>();
        this.operadores = new ArrayList<>();
    }

    public void agregarAtraccion(Atraccion atraccion) {
        atracciones.add(atraccion);
    }

    public void asignarOperador(Operador operador) {
        operadores.add(operador);
        operador.setZonaAsignada(this);
    }

    public boolean hayCupo() {
        return atracciones.size() < aforoMaximo;
    }

    public Atraccion buscarAtraccion(String id) {
        for (Atraccion atraccion : atracciones) {
            if (atraccion.getId().equals(id)) {
                return atraccion;
            }
        }

        return null;
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

    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }

    public ArrayList<Operador> getOperadores() {
        return operadores;
    }
}
