package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket;

public class TicketGeneral extends Ticket {

    public TicketGeneral(String codigo, double precio, String fechaCompra) {
        super(codigo, precio, fechaCompra, TipoTicket.GENERAL);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio();
    }
}
