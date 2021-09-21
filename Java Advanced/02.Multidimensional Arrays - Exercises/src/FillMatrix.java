import java.util.ArrayList;
import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] requirements = scan.nextLine().split(", ");

        int matrixSize = Integer.parseInt(requirements[0]);
        String pattern = requirements[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if(pattern.equals("A")){
            createPatternAMatrix(matrix, matrixSize);
        } else if(pattern.equals("B")){
            createPatternBMatrix(matrix, matrixSize);
        }

        printMatrix(matrix);
    }

    public static void createPatternAMatrix(int[][] matrix, int size){
        int number = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = number++;
            }
        }
    }

    public static void createPatternBMatrix(int[][] matrix, int size){
        int number = 1;

        for (int col = 0; col < size; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = number++;
                }
            } else {
                for (int row = size-1; row >= 0 ; row--) {
                    matrix[row][col] = number++;
                }
            }
        }
    }

    public static void printMatrix(int [][] matrix){
        ArrayList<String> matrixRows = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder currentRow = new StringBuilder();

            for (int j = 0; j < matrix[i].length; j++) {
                currentRow.append(matrix[i][j] + " ");
            }

            matrixRows.add(currentRow.toString());
        }

        System.out.println(String.join("\n", matrixRows));
    }
}
