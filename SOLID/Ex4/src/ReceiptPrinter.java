import java.util.*;

public class ReceiptPrinter {
    public static void print(RoomPricing room, List<AddOnPricing> addOns, Money monthly, Money deposit) {
        List<String> names = new ArrayList<>();
        for (AddOnPricing addOn : addOns) {
            names.add(addOn.displayName());
        }
        System.out.println("Room: " + room.displayName() + " | AddOns: " + names);
        System.out.println("Monthly: " + monthly);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }
}
