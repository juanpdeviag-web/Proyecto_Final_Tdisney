package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket;

public class TicketFamiliar extends Ticket {
    private int cantidadPersonas;

    public TicketFamiliar(String codigo, double precio, String fechaCompra, int cantidadPersonas) {
        super(codigo, precio, fechaCompra, TipoTicket.FAMILIAR);
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public double calcularPrecioFinal() {
        double total = getPrecio() * cantidadPersonas;
        double descuento = total * 0.15;
        return total - descuento;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
