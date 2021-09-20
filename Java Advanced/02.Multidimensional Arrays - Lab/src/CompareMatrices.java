import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixData = readArray(scan, "\\s+");

        int rows = matrixData[0];
        int columns = matrixData[1];

        int[][] firstMatrix = readMatrix(rows, columns, " ", scan);

        matrixData = readArray(scan, "\\s+");

        rows = matrixData[0];
        columns = matrixData[1];

        int[][] secondMatrix = readMatrix(rows, columns, "\\s+", scan);

        if(checkIfMatrixAreDeepEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean checkIfMatrixAreDeepEqual(int[][] firstMatrix, int[][] secondMatrix) {
        return Arrays.deepEquals(firstMatrix, secondMatrix);
    }

    public static int[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = readArray(scan, delimiter);

            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        return matrix;
    }

    public static int[] readArray(Scanner scan, String delimiter){
        return Arrays
                .stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
