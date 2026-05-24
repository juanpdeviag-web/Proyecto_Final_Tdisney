package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona.Visitante;

import java.util.ArrayList;

public abstract class Atraccion {
    private String id;
    private String nombre;
    private int capacidad;
    private double estaturaMinima;
    private int edadMinima;
    private int contadorVisitantes;
    private EstadoAtraccion estado;
    private ArrayList<Visitante> colaNormal;
    private ArrayList<Visitante> colaFastPass;

    public Atraccion(String id, String nombre, int capacidad, double estaturaMinima, int edadMinima) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estaturaMinima = estaturaMinima;
        this.edadMinima = edadMinima;
        this.contadorVisitantes = 0;
        this.estado = EstadoAtraccion.ACTIVA;
        this.colaNormal = new ArrayList<>();
        this.colaFastPass = new ArrayList<>();
    }

    public boolean validarAcceso(Visitante visitante) {
        if (visitante == null) {
            return false;
        }

        if (estado != EstadoAtraccion.ACTIVA) {
            return false;
        }

        if (!visitante.tieneTicket()) {
            return false;
        }

        if (visitante.getEdad() < edadMinima) {
            return false;
        }

        if (visitante.getEstatura() < estaturaMinima) {
            return false;
        }

        return true;
    }

    public void agregarACola(Visitante visitante) {
        if (visitante.tieneFastPass()) {
            colaFastPass.add(visitante);
        } else {
            colaNormal.add(visitante);
        }
    }

    public Visitante atenderSiguienteVisitante() {
        Visitante visitante = null;

        if (!colaFastPass.isEmpty()) {
            visitante = colaFastPass.get(0);
            colaFastPass.remove(0);
        } else if (!colaNormal.isEmpty()) {
            visitante = colaNormal.get(0);
            colaNormal.remove(0);
        }

        return visitante;
    }

    public boolean registrarIngreso(Visitante visitante) {
        if (validarAcceso(visitante)) {
            contadorVisitantes++;
            visitante.registrarVisita(this);

            if (contadorVisitantes >= 500) {
                estado = EstadoAtraccion.MANTENIMIENTO;
            }

            return true;
        }

        return false;
    }

    public void cambiarEstado(EstadoAtraccion nuevoEstado) {
        estado = nuevoEstado;
    }

    public abstract boolean cerrarPorClima();

    public int calcularTiempoEspera() {
        int personasEnCola = colaNormal.size() + colaFastPass.size();
        return personasEnCola * 3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getEstaturaMinima() {
        return estaturaMinima;
    }

    public void setEstaturaMinima(double estaturaMinima) {
        this.estaturaMinima = estaturaMinima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getContadorVisitantes() {
        return contadorVisitantes;
    }

    public void setContadorVisitantes(int contadorVisitantes) {
        this.contadorVisitantes = contadorVisitantes;
    }

    public EstadoAtraccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoAtraccion estado) {
        this.estado = estado;
    }

    public ArrayList<Visitante> getColaNormal() {
        return colaNormal;
    }

    public ArrayList<Visitante> getColaFastPass() {
        return colaFastPass;
    }
}
