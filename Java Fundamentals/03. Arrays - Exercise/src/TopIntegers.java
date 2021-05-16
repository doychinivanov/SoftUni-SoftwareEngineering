import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(i == arr.length-1){
                System.out.print(num);
                break;
            }

            boolean isBigger = false;

            for (int j = i +1; j < arr.length; j++) {
                if(num > arr[j]){
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }

            if(isBigger){
                System.out.print(num + " ");
            }
        }
    }
}