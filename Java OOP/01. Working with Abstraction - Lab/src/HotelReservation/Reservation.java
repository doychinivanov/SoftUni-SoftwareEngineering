package HotelReservation;

public class Reservation {
    private final double pricePerDay;
    private final int days;
    private final String season;
    private final String discountType;

    public Reservation(double pricePerDay, int days, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public int getDays() {
        return this.days;
    }

    public String getSeason() {
        return this.season;
    }

    public String getDiscountType() {
        return discountType;
    }
}
