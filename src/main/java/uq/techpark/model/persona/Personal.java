package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

public abstract class Personal extends Persona {
    private String idPersonal;
    private String usuario;
    private String contrasena;

    public Personal(String nombre, String documento, String correo, int edad,
                    String idPersonal, String usuario, String contrasena) {
        super(nombre, documento, correo, edad);
        this.idPersonal = idPersonal;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public boolean validarCredenciales(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
