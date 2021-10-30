package HotelReservation;

public enum Discount {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private final double value;

    Discount(double v) {
        this.value = v;
    }

    public double getValue() {
        return this.value;
    }
}
