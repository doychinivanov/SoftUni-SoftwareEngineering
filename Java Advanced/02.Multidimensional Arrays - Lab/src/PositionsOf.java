import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixData = readArray(scan);
        int rows = matrixData[0];
        int columns = matrixData[1];

        int[][] matrix = readMatrix(rows, columns, " ", scan);
        int numberToBeFound = Integer.parseInt(scan.nextLine());

        List<int[]> foundPositions = findPositions(matrix, numberToBeFound);

        if(foundPositions.isEmpty()){
            System.out.println("not found");
        } else {
            foundPositions.forEach(PositionsOf::printArray);
        }

    }

    public static void printArray(int[] arr){
        StringBuilder result = new StringBuilder();

        for (int element: arr) {
            result.append(element + " ");
        }

        System.out.println(result);
    }

    public static List<int[]> findPositions (int[][] matrix, int number){
        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == number){
                    positions.add(new int[]{i, j});
                }
            }
        }

        return positions;
    }

    public static int[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = readArray(scan);

            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        return matrix;
    }

    public static int[] readArray(Scanner scan){
        return Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
