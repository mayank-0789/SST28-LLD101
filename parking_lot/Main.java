package parking_lot;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<SlotType, Double> rates = new HashMap<>();
        rates.put(SlotType.SMALL, 3.0);
        rates.put(SlotType.MEDIUM, 8.0);
        rates.put(SlotType.LARGE, 15.0);

        SpotAssignmentStrategy assignment = new NearestSpotStrategy();
        FeeStrategy fee = new HourlyFeeStrategy(rates);

        ParkingLot lot = new ParkingLot(assignment, fee);

        Gate mainGate = new Gate("G1", 1, 0, 0);
        lot.addGate(mainGate);

        lot.addSpot(new ParkingSpot("P1", SlotType.MEDIUM, 1, 15, 20));
        lot.addSpot(new ParkingSpot("P2", SlotType.MEDIUM, 1, 40, 35));
        lot.addSpot(new ParkingSpot("P3", SlotType.SMALL, 2, 10, 10));
        lot.addSpot(new ParkingSpot("P4", SlotType.LARGE, 2, 20, 20));

        lot.showStatus();

        Vehicle myCar = new Vehicle("KA-01-1234", VehicleType.CAR);
        ParkingTicket ticket = lot.park(myCar, mainGate);

        if (ticket != null) {
            long threeHoursAgo = System.currentTimeMillis() - (3 * 60 * 60 * 1000);
            ticket.setEntryTime(threeHoursAgo);
            lot.exit(ticket);
        }

        lot.showStatus();
    }
}
