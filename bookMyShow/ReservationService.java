import java.util.List;

public class ReservationService {
    private HoldManager holdMgr;
    private PriceCalculator priceCalc;

    public ReservationService(HoldManager holdMgr, PriceCalculator priceCalc) {
        this.holdMgr = holdMgr;
        this.priceCalc = priceCalc;
    }

    public Reservation initiateReservation(Customer customer, Screening screening,
                                           List<ScreeningChair> chosen) throws Exception {
        boolean held = holdMgr.holdChairs(chosen, customer);

        if (!held) {
            throw new Exception("One or more chairs are already taken or held by someone else.");
        }

        double total = 0;
        for (ScreeningChair sc : chosen) {
            total += priceCalc.getPrice(sc, screening);
        }

        return new Reservation(customer, screening, chosen, total);
    }

    public boolean finalizePayment(Reservation reservation) {
        if (reservation.getState() == ReservationState.DROPPED) return false;

        for (ScreeningChair sc : reservation.getChairs()) {
            if (sc.isHoldExpired()) {
                holdMgr.releaseChairs(reservation.getChairs());
                reservation.drop();
                return false;
            }
        }

        for (ScreeningChair sc : reservation.getChairs()) {
            sc.reserve();
        }
        reservation.markDone();
        return true;
    }

    public void dropReservation(Reservation reservation) {
        if (reservation.getState() != ReservationState.DROPPED) {
            for (ScreeningChair sc : reservation.getChairs()) {
                sc.release();
            }
            reservation.drop();
        }
    }
}
