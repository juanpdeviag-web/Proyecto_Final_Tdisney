package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.Atraccion;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.AtraccionAcuatica;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.AtraccionGeneral;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion.AtraccionMecanicaAlta;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque.Parque;
import modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.parque.Zona;

public class Administrador extends Empleado {

    public Administrador(String nombre, String documento, String correo, int edad,
                         String idPersonal, String usuario, String contrasena) {
        super(nombre, documento, correo, edad, idPersonal, usuario, contrasena, "Administrador");
    }

    public Zona crearZona(String nombre, int aforoMaximo) {
        return new Zona(nombre, aforoMaximo);
    }

    public AtraccionGeneral crearAtraccionGeneral(String id, String nombre, int capacidad,
                                                  double estaturaMinima, int edadMinima) {
        return new AtraccionGeneral(id, nombre, capacidad, estaturaMinima, edadMinima);
    }

    public AtraccionAcuatica crearAtraccionAcuatica(String id, String nombre, int capacidad,
                                                    double estaturaMinima, int edadMinima) {
        return new AtraccionAcuatica(id, nombre, capacidad, estaturaMinima, edadMinima);
    }

    public AtraccionMecanicaAlta crearAtraccionMecanicaAlta(String id, String nombre, int capacidad,
                                                            double estaturaMinima, int edadMinima) {
        return new AtraccionMecanicaAlta(id, nombre, capacidad, estaturaMinima, edadMinima);
    }

    public void agregarZonaAlParque(Parque parque, Zona zona) {
        parque.agregarZona(zona);
    }

    public void agregarAtraccionAZona(Zona zona, Atraccion atraccion) {
        zona.agregarAtraccion(atraccion);
    }

    public void asignarOperadorAZona(Operador operador, Zona zona) {
        zona.asignarOperador(operador);
    }

    public void activarAlertaClima(Parque parque) {
        parque.activarAlertaClima();
    }

    public void desactivarAlertaClima(Parque parque) {
        parque.desactivarAlertaClima();
    }

    @Override
    public String getTipoPersona() {
        return "Administrador";
    }
}
