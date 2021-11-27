import java.util.Scanner;

public class GeneratingVectors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vectorSize = Integer.parseInt(scan.nextLine());
        int[] vector = new int[vectorSize];

        createVector(vector, 0);
    }

    private static void createVector(int[] vector, int index) {
        if( index >= vector.length) {
            printVector(vector);
            return;
        }

        populateWithValues(vector, 0, index);
    }

    private static void populateWithValues(int[] vector, int value, int index){
        if (value > 1) {
            return;
        }

        vector[index] = value;
        createVector(vector, index + 1);
        populateWithValues(vector, value + 1, index);
    }

    private static void printVector(int[] vector) {
        StringBuilder result = new StringBuilder();

        for (int n: vector) {
            result.append(n);
        }

        System.out.println(result);
    }
}
