package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.EstadoAtraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque.Zona;

public class Operador extends Empleado {
    private Zona zonaAsignada;

    public Operador(String nombre, String documento, String correo, int edad,
                    String idPersonal, String usuario, String contrasena) {
        super(nombre, documento, correo, edad, idPersonal, usuario, contrasena, "Operador");
    }

    public boolean validarAcceso(Visitante visitante, Atraccion atraccion) {
        if (zonaAsignada == null) {
            return false;
        }

        if (!zonaAsignada.getAtracciones().contains(atraccion)) {
            return false;
        }

        return atraccion.validarAcceso(visitante);
    }

    public boolean registrarIngreso(Visitante visitante, Atraccion atraccion) {
        if (validarAcceso(visitante, atraccion)) {
            return atraccion.registrarIngreso(visitante);
        }

        return false;
    }

    public void registrarRevisionTecnica(Atraccion atraccion) {
        if (atraccion.getEstado() == EstadoAtraccion.MANTENIMIENTO) {
            atraccion.setEstado(EstadoAtraccion.ACTIVA);
            atraccion.setContadorVisitantes(0);
        }
    }

    @Override
    public String getTipoPersona() {
        return "Operador";
    }

    public Zona getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(Zona zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }
}
