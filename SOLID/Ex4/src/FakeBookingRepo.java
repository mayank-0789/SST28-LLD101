import java.util.*;

public class FakeBookingRepo {
    public void save(String id, RoomPricing room, List<AddOnPricing> addOns, Money monthly, Money deposit) {
        System.out.println("Saved booking: " + id);
    }
}
