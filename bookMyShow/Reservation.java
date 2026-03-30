import java.util.List;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private Customer customer;
    private Screening screening;
    private List<ScreeningChair> chairs;
    private double totalPrice;
    private ReservationState state;

    public Reservation(Customer customer, Screening screening, List<ScreeningChair> chairs, double totalPrice) {
        this.reservationId = UUID.randomUUID().toString();
        this.customer = customer;
        this.screening = screening;
        this.chairs = chairs;
        this.totalPrice = totalPrice;
        this.state = ReservationState.AWAITING_PAYMENT;
    }

    public String getReservationId() { return reservationId; }
    public List<ScreeningChair> getChairs() { return chairs; }
    public ReservationState getState() { return state; }
    public double getTotalPrice() { return totalPrice; }

    public void markDone() { this.state = ReservationState.DONE; }
    public void drop() { this.state = ReservationState.DROPPED; }
}
