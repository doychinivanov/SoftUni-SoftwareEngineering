import java.util.Scanner;

public class ArrRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());

        for(int i = 1; i <= rotations; i++){
            String firstEl = arr[0];

            for (int j = 0; j < arr.length -1; j++) {
                arr[j] = arr[j+1];
            }

            arr[arr.length-1] = firstEl;
        }

        System.out.println(String.join(" ", arr));
    }
}