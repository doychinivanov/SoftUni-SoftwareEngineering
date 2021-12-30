import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveDownRight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[rows][cols];
        int[][] dpMatrix = new int[rows][cols];

        readMatrix(reader, rows, matrix);

        createDPMatrix(rows, cols, matrix, dpMatrix);

        List<String> path = findBestPath(rows, cols, dpMatrix);

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }

    private static List<String> findBestPath(int rows, int cols, int[][] dpMatrix) {
        int lastElRow = rows -1;
        int lastElCol = cols -1 ;

        List<String> path = new ArrayList<>();

        path.add(formatOutput(lastElRow, lastElCol));

        while (lastElRow > 0 || lastElCol > 0) {
            int topElement = -1;
            int leftElement = -1;

            if(lastElRow > 0) {
                topElement = dpMatrix[lastElRow-1][lastElCol];
            }

            if (lastElCol > 0) {
                leftElement = dpMatrix[lastElRow][lastElCol - 1];
            }

            if (topElement > leftElement) {
                lastElRow--;
            } else {
                lastElCol--;
            }

            path.add(formatOutput(lastElRow, lastElCol));
        }
        return path;
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }

    private static void createDPMatrix(int rows, int cols, int[][] matrix, int[][] dpMatrix) {
        createFirstRow(cols, matrix, dpMatrix);

        createFirstCol(rows, matrix, dpMatrix);

        createInsideOfMatrix(rows, cols, matrix, dpMatrix);
    }

    private static void createInsideOfMatrix(int rows, int cols, int[][] matrix, int[][] dpMatrix) {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dpMatrix[i][j] = Math.max(dpMatrix[i-1][j] + matrix[i][j],
                        dpMatrix[i][j-1] + matrix[i][j]);
            }
        }
    }

    private static void createFirstCol(int rows, int[][] matrix, int[][] dpMatrix) {
        for (int i = 1; i < rows; i++) {
            dpMatrix[i][0] = dpMatrix[i-1][0] + matrix[i][0];
        }
    }

    private static void createFirstRow(int cols, int[][] matrix, int[][] dpMatrix) {
        dpMatrix[0][0] = matrix[0][0];

        for (int i = 1; i < cols; i++) {
            dpMatrix[0][i] = dpMatrix[0][i-1] + matrix[0][i];
        }
    }

    private static void readMatrix(BufferedReader reader, int rows, int[][] matrix) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
