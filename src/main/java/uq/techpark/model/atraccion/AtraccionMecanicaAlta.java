package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.atraccion;

public class AtraccionMecanicaAlta extends Atraccion {

    public AtraccionMecanicaAlta(String id, String nombre, int capacidad, double estaturaMinima, int edadMinima) {
        super(id, nombre, capacidad, estaturaMinima, edadMinima);
    }

    @Override
    public boolean cerrarPorClima() {
        return true;
    }
}
