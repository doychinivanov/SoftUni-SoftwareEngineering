import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            if(checkDivisibility(i) && checkForOddDigits(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean checkDivisibility(int n){
        int sum = 0;
        boolean isDivisible = false;

        while(n > 0){
            sum += n % 10;
            n = n / 10;
        }

        if(sum % 8 == 0){
            isDivisible = true;
        }

        return isDivisible;
    }

    private static boolean checkForOddDigits(int n){
        boolean isValid = false;
        String numberToString = Integer.toString(n);

        for (int i = 0; i < numberToString.length(); i++) {
            if(Character.getNumericValue(numberToString.charAt(i)) % 2 != 0){
                isValid = true;
                break;
            }
        }

        return isValid;
    }
}
