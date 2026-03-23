package parking_lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private List<Gate> gates;
    private SpotAssignmentStrategy assignmentStrategy;
    private FeeStrategy feeStrategy;

    public ParkingLot(SpotAssignmentStrategy assignmentStrategy, FeeStrategy feeStrategy) {
        this.spots = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.assignmentStrategy = assignmentStrategy;
        this.feeStrategy = feeStrategy;
    }

    public void addSpot(ParkingSpot spot) { spots.add(spot); }
    public void addGate(Gate gate) { gates.add(gate); }

    public ParkingTicket park(Vehicle vehicle, Gate gate) {
        try {
            System.out.println("Parking " + vehicle.getType() + " (" + vehicle.getNumberPlate() + ") at Gate " + gate.getId());
            ParkingSpot spot = assignmentStrategy.findSpot(gate, spots, vehicle.getType());

            spot.occupy();
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            System.out.println("Assigned spot " + spot.getId() + " on floor " + spot.getFloor());
            return ticket;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public double exit(ParkingTicket ticket) {
        ticket.getSpot().vacate();
        long now = System.currentTimeMillis();
        double fee = feeStrategy.calculateFee(ticket, now);

        System.out.println(ticket.getVehicle().getNumberPlate() + " exited from spot " +
                           ticket.getSpot().getId() + ". Fee: $" + fee);
        return fee;
    }

    public void showStatus() {
        Map<SlotType, Long> available = spots.stream()
            .filter(spot -> !spot.isOccupied())
            .collect(Collectors.groupingBy(ParkingSpot::getType, Collectors.counting()));

        System.out.println("\n--- Parking Status ---");
        if (available.isEmpty()) {
            System.out.println("No spots available.");
        } else {
            available.forEach((type, count) ->
                System.out.println(type + ": " + count + " available"));
        }
        System.out.println("----------------------\n");
    }
}
