package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

public class Empleado extends Personal {
    private String cargo;

    public Empleado(String nombre, String documento, String correo, int edad,
                    String idPersonal, String usuario, String contrasena, String cargo) {
        super(nombre, documento, correo, edad, idPersonal, usuario, contrasena);
        this.cargo = cargo;
    }

    public void mostrarInformacionEmpleado() {
        System.out.println("Empleado: " + getNombre());
        System.out.println("Cargo: " + cargo);
        System.out.println("Documento: " + getDocumento());
    }

    @Override
    public String getTipoPersona() {
        return "Empleado";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
