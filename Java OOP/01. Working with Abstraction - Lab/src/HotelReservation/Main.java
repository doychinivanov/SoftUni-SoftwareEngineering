package HotelReservation;

public class Main {
    public static void main(String[] args) {
        String[] tokens = Reader.readStringArr("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discountType = parseType(tokens[3]);

        Reservation reservation = new Reservation(pricePerDay, days, season, discountType);
        PriceCalculator calculator = new PriceCalculator(reservation);

        double finalSum = calculator.getPriceForHoliday();

        System.out.printf("%.2f",finalSum);
    }

    private static String parseType(String type){
        if(type.equals("SecondVisit")){
            return "SECOND_VISIT";
        }

        return type;
    }
}
