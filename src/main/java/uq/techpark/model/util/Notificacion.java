package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.persona;

public class Notificacion {
    private String mensaje;
    private String destinatario;
    private boolean leida;

    public Notificacion(String mensaje, String destinatario) {
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.leida = false;
    }

    public void marcarComoLeida() {
        leida = true;
    }

    public String mostrarNotificacion() {
        return "Para: " + destinatario + " - Mensaje: " + mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }
}
