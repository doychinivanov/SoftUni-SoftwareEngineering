package HotelReservation;

import java.util.Locale;

public class PriceCalculator {
    private final Reservation reservation;

    public PriceCalculator(Reservation reservation){
        this.reservation = reservation;
    }

    public double getPriceForHoliday(){
        double pricePerDayAccordingToSeason = Season.valueOf(reservation.getSeason().toUpperCase(Locale.ROOT)).getValue() * reservation.getPricePerDay();
        double priceForThePeriodWithNODiscount = pricePerDayAccordingToSeason * reservation.getDays();
        double priceWithDiscount = priceForThePeriodWithNODiscount * Discount.valueOf(reservation.getDiscountType().toUpperCase(Locale.ROOT)).getValue();

        return priceWithDiscount;
    }
}
