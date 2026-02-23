import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(RoomPricing room, List<AddOnPricing> addOns, List<FeePricing> fees) {
        Money monthly = room.monthlyFee();

        for (AddOnPricing addOn : addOns) {
            monthly = monthly.plus(addOn.price());
        }

        for (FeePricing fee : fees) {
            monthly = monthly.plus(fee.calculate());
        }

        Money deposit = room.depositFee();

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));

        ReceiptPrinter.print(room, addOns, monthly, deposit);
        repo.save(bookingId, room, addOns, monthly, deposit);
    }
}
