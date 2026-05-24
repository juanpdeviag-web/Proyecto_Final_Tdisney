package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

public abstract class Persona {
    private String nombre;
    private String documento;
    private String correo;
    private int edad;

    public Persona(String nombre, String documento, String correo, int edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public abstract String getTipoPersona();
}
