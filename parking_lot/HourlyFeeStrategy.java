package parking_lot;

import java.util.Map;

public class HourlyFeeStrategy implements FeeStrategy {
    private Map<SlotType, Double> rates;

    public HourlyFeeStrategy(Map<SlotType, Double> rates) {
        this.rates = rates;
    }

    @Override
    public double calculateFee(ParkingTicket ticket, long exitTimeMillis) {
        long durationMillis = exitTimeMillis - ticket.getEntryTime();
        double hours = Math.ceil(durationMillis / (1000.0 * 60 * 60));
        if (hours == 0) hours = 1;

        double rate = rates.getOrDefault(ticket.getSpot().getType(), 10.0);
        return hours * rate;
    }
}
