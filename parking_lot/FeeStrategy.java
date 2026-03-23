package parking_lot;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket, long exitTimeMillis);
}
