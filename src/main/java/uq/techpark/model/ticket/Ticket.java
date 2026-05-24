package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket;

public abstract class Ticket {
    private String codigo;
    private double precio;
    private String fechaCompra;
    private TipoTicket tipo;

    public Ticket(String codigo, double precio, String fechaCompra, TipoTicket tipo) {
        this.codigo = codigo;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.tipo = tipo;
    }

    public abstract double calcularPrecioFinal();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public TipoTicket getTipo() {
        return tipo;
    }

    public void setTipo(TipoTicket tipo) {
        this.tipo = tipo;
    }
}
