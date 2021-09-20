import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(length, 0, "\\s+", scan);

        int[] wrongElementPosition = readArray(scan, "\\s+");
        int wrongElement = matrix[wrongElementPosition[0]][wrongElementPosition[1]];

        List<int[]> dataForNewMatrix = findPositionForWrongElements(matrix, wrongElement);

        refactorMatrix(matrix, dataForNewMatrix);
        printMatrix(matrix);

    }

    public static void refactorMatrix(int[][] matrix, List<int[]> newValues){
        newValues.forEach(arr -> matrix[arr[0]][arr[1]] = arr[2]);
    }

    public static List<int[]> findPositionForWrongElements(int[][] matrix, int wrongElement){
        List<int[]> coordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == wrongElement){
                    int newValue = findNewValue(matrix, i, j, wrongElement);

                    coordinates.add(new int[] {i, j, newValue});
                }
            }
        }

        return coordinates;
    }

    public static int findNewValue(int[][] matrix, int x, int y, int wrongElement){
        int newValue = 0;

        if(y-1 >= 0 && matrix[x][y-1] != wrongElement){
            newValue += matrix[x][y-1];
        }

        if(y+1 < matrix[0].length && matrix[x][y+1] != wrongElement){
            newValue += matrix[x][y+1];
        }

        if(x-1 >= 0 && matrix[x-1][y] != wrongElement){
            newValue += matrix[x-1][y];
        }

        if(x+1 < matrix.length && matrix[x+1][y] != wrongElement){
            newValue += matrix[x+1][y];
        }

        return newValue;
    }

    public static int[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = readArray(scan, delimiter);

            matrix[i] = currentRow;
        }

        return matrix;
    }

    public static int[] readArray(Scanner scan, String delimiter){
        return Arrays
                .stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
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
