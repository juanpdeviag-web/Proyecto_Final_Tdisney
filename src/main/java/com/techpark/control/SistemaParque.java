package com.techpark.control;

import com.techpark.model.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

    public class SistemaParque {
        private static SistemaParque instancia;

        private List<Zona> zonas;
        private List<Atraccion> atraccionesGlobales;
        private List<Visitante> visitantes;
        private List<Empleado> empleados;
        private List<Ticket> ticketsVendidos;
        private String climaActual;

        private SistemaParque() {
            this.zonas = new ArrayList<>();
            this.atraccionesGlobales = new ArrayList<>();
            this.visitantes = new ArrayList<>();
            this.empleados = new ArrayList<>();
            this.ticketsVendidos = new ArrayList<>();
            this.climaActual = "despejado";
        }

        public static SistemaParque getInstancia() {
            if (instancia == null) {
                instancia = new SistemaParque();
            }
            return instancia;
        }



        // ========== MÉTODOS DE GESTIÓN DE COLECCIONES ==========

        public void agregarZona(Zona zona) {
            if (zona != null && !zonas.contains(zona)) {
                zonas.add(zona);
            }
        }

        public void agregarAtraccion(Atraccion atraccion) {
            if (atraccion != null && !atraccionesGlobales.contains(atraccion)) {
                atraccionesGlobales.add(atraccion);
            }
        }

        public void registrarVisitante(Visitante visitante) {
            if (visitante != null && !visitantes.contains(visitante)) {
                visitantes.add(visitante);
            }
        }

        public void registrarEmpleado(Empleado empleado) {
            if (empleado != null && !empleados.contains(empleado)) {
                empleados.add(empleado);
            }
        }

        public void venderTicket(Ticket ticket) {
            if (ticket != null) {
                ticketsVendidos.add(ticket);
            }
        }

        // ========== MÉTODOS DE BÚSQUEDA ==========

        public Visitante buscarVisitantePorDocumento(String documento) {
            return visitantes.stream()
                    .filter(v -> v.getIdDocumento().equals(documento))
                    .findFirst()
                    .orElse(null);
        }

        public Empleado autenticarEmpleado(String usuario, String contrasena) {
            return empleados.stream()
                    .filter(e -> e.autenticar(usuario, contrasena))
                    .findFirst()
                    .orElse(null);
        }

        public Atraccion buscarAtraccionPorId(String idAtraccion) {
            return atraccionesGlobales.stream()
                    .filter(a -> a.getIdAtraccion().equals(idAtraccion))
                    .findFirst()
                    .orElse(null);
        }

        // ========== GETTERS Y SETTERS ==========

        public List<Zona> getZonas() {
            return zonas;
        }

        public List<Atraccion> getAtraccionesGlobales() {
            return atraccionesGlobales;
        }

        public List<Visitante> getVisitantes() {
            return visitantes;
        }

        public List<Empleado> getEmpleados() {
            return empleados;
        }

        public List<Ticket> getTicketsVendidos() {
            return ticketsVendidos;
        }

        public String getClimaActual() {
            return climaActual;
        }

        public void setClimaActual(String climaActual) {
            this.climaActual = climaActual;
        }

        /**
         * Calcula el aforo total del parque sumando todos los aforos de las zonas
         */
        public int calcularAforoTotal() {
            return zonas.stream()
                    .mapToInt(Zona::getAforoMaximo)
                    .sum();
        }

        /**
         * Calcula la cantidad de visitantes actualmente en el parque
         * (visitantes que tienen ticket y han ingresado al menos una vez)
         */
        public int calcularVisitantesActivos() {
            return (int) visitantes.stream()
                    .filter(v -> v.getTicket() != null && !v.getHistorialVisitas().isEmpty())
                    .count();
        }

        /**
         * Calcula el porcentaje de ocupación del parque
         */
        public double calcularPorcentajeOcupacion() {
            int aforoTotal = calcularAforoTotal();
            if (aforoTotal == 0) return 0.0;
            return (calcularVisitantesActivos() * 100.0) / aforoTotal;
        }
    }
}
