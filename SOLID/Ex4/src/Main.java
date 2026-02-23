import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());

        RoomPricing room = new DoubleRoomPricing();

        List<AddOnPricing> addOns = new ArrayList<>();
        addOns.add(new LaundryPricing());
        addOns.add(new MessPricing());

        List<FeePricing> fees = new ArrayList<>();

        calc.process(room, addOns, fees);
    }
}
