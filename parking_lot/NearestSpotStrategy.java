package parking_lot;

import java.util.List;

public class NearestSpotStrategy implements SpotAssignmentStrategy {

    private SlotType mapVehicleToSlot(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE: return SlotType.SMALL;
            case CAR: return SlotType.MEDIUM;
            case TRUCK: return SlotType.LARGE;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }

    @Override
    public ParkingSpot findSpot(Gate entryGate, List<ParkingSpot> spots, VehicleType vehicleType) throws Exception {
        SlotType needed = mapVehicleToSlot(vehicleType);

        ParkingSpot nearest = null;
        double minDist = Double.MAX_VALUE;

        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getType() == needed) {
                double dist = spot.distanceFrom(entryGate);
                if (dist < minDist) {
                    minDist = dist;
                    nearest = spot;
                }
            }
        }

        if (nearest == null) {
            throw new Exception("No available spots for type: " + needed);
        }
        return nearest;
    }
}
