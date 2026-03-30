import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HoldManager holdMgr = new HoldManager(5 * 60 * 1000);
        PriceCalculator priceCalc = new DemandBasedPricing();
        ReservationService service = new ReservationService(holdMgr, priceCalc);

        Customer cust1 = new Customer("rahul@mail.com", "Rahul");
        Customer cust2 = new Customer("priya@mail.com", "Priya");

        Film film = new Film("F1", "Interstellar", "English");
        Cinema cinema = new Cinema("C1", "PVR Orion", "Bangalore");
        Hall hall = new Hall("H1", "Audi 3", cinema);

        Chair ch1 = new Chair("CH1", 2, 5, Tier.PREMIUM);
        Chair ch2 = new Chair("CH2", 2, 6, Tier.PREMIUM);

        ScreeningChair sc1 = new ScreeningChair("SC1", ch1);
        ScreeningChair sc2 = new ScreeningChair("SC2", ch2);
        List<ScreeningChair> available = Arrays.asList(sc1, sc2);

        Screening show = new Screening("SCR1", film, hall, System.currentTimeMillis(), available);

        System.out.println("--- concurrency test ---");

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Rahul trying to book...");
                Reservation r = service.initiateReservation(cust1, show, available);
                System.out.println("Rahul got hold! Total: " + r.getTotalPrice());

                boolean ok = service.finalizePayment(r);
                System.out.println("Rahul payment: " + (ok ? "success" : "failed"));
            } catch (Exception e) {
                System.out.println("Rahul failed: " + e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Priya trying same chairs...");
                Reservation r = service.initiateReservation(cust2, show, available);
                System.out.println("Priya got hold!");
            } catch (Exception e) {
                System.out.println("Priya failed: " + e.getMessage());
            }
        });

        t1.start();

        try { Thread.sleep(100); } catch (InterruptedException ignored) {}

        t2.start();
    }
}
