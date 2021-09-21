import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DiagonalDiff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(length, length, " ", scan);

        List<String> diagonals = findDiagonals(matrix);
        List<Integer> diagonalsSum = new ArrayList<>();

        diagonals.forEach(diagonal -> {
            int sum = findDiagonalSum(diagonal);

            diagonalsSum.add(sum);
        });

        System.out.println(Math.abs(diagonalsSum.get(0) - diagonalsSum.get(1)));
    }

    private static int findDiagonalSum(String diagonal) {
        int sum = 0;

        int[] diagonalValues = Arrays.stream(diagonal.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        sum = Arrays.stream(diagonalValues).sum();

        return sum;
    }

    public static List<String> findDiagonals(int[][] matrix){
        List<String> diagonals = new ArrayList<>();

        StringBuilder downDiagonal = new StringBuilder();
        StringBuilder upperDiagonal = new StringBuilder();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i != j) continue;

                downDiagonal.append(matrix[i][j]).append(" ");
            }
        }

        int k = 0;
        for (int i = matrix.length - 1; i >=0; i--) {
            upperDiagonal.append(matrix[i][k]).append(" ");
            k++;
        }

        diagonals.add(downDiagonal.toString());
        diagonals.add(upperDiagonal.toString());

        return diagonals;
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
