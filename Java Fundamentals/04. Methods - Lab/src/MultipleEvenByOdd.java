import java.util.Scanner;

public class MultipleEvenByOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int num = Math.abs(Integer.parseInt(scan.nextLine()));

        System.out.println(multiplyEvOdd(num));
    }

    public static Integer multiplyEvOdd(int number){
        int evenSum = getEvenSum(number);
        int oddSum = getOddSum(number);

        return  evenSum * oddSum;
    }

    public static Integer getEvenSum(int number){
        int sum = 0;

        while (number > 0){
            int digit = number % 10;
            if(digit % 2 == 0){
                sum += digit;
            }
            number = number / 10;
        }

        return  sum;
    }

    public static Integer getOddSum(int number){
        int sum = 0;

        while (number > 0){
            int digit = number % 10;
            if(digit % 2 != 0){
                sum += digit;
            }
            number = number / 10;
        }

        return  sum;
    }
}
