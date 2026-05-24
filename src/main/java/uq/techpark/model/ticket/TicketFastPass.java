package modelo.Proyecto_Final_Tdisney.src.main.java.uq.techpark.model.ticket;

public class TicketFastPass extends Ticket {

    public TicketFastPass(String codigo, double precio, String fechaCompra) {
        super(codigo, precio, fechaCompra, TipoTicket.FAST_PASS);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() + 30000;
    }
}
