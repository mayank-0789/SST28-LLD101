public class DemandBasedPricing implements PriceCalculator {

    @Override
    public double getPrice(ScreeningChair sc, Screening screening) {
        double base = (sc.getChair().getTier() == Tier.PREMIUM) ? 320.0 : 160.0;
        double surge = 1.15;
        return base * surge;
    }
}
