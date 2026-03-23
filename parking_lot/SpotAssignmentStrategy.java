package parking_lot;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(Gate entryGate, List<ParkingSpot> spots, VehicleType vehicleType) throws Exception;
}
