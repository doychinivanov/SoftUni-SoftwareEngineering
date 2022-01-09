import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Climbing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[rows][cols];
        int[][] dpMatrix = new int[rows][cols];

        readMatrix(reader, rows, matrix);

        createDPMatrix(rows, cols, matrix, dpMatrix);

        System.out.println(dpMatrix[0][0]);

        List<String> path = findBestPath(rows, cols, dpMatrix, matrix);
        Collections.reverse(path);

        System.out.println(String.join(" ", path));
    }

    private static List<String> findBestPath(int rows, int cols, int[][] dpMatrix, int[][] matrix) {
        int lastElRow = 0;
        int lastElCol = 0;

        List<String> path = new ArrayList<>();
        path.add(String.valueOf(matrix[lastElRow][lastElCol]));

        while (lastElRow < rows - 1 || lastElCol < cols - 1) {
            int bottomElement = -1;
            int rightElement = -1;

            if (lastElRow < rows - 1) {
                bottomElement = dpMatrix[lastElRow + 1][lastElCol];
            }

            if (lastElCol < cols - 1) {
                rightElement = dpMatrix[lastElRow][lastElCol + 1];
            }

            if (bottomElement >= rightElement) {
                lastElRow++;
            } else {
                lastElCol++;
            }

            path.add(String.valueOf(matrix[lastElRow][lastElCol]));
        }

        return path;
    }

    private static void createDPMatrix(int rows, int cols, int[][] matrix, int[][] dpMatrix) {
        createFirstRow(cols - 1,rows - 1, matrix, dpMatrix);

        createFirstCol(rows - 1, cols - 1, matrix, dpMatrix);

        createInsideOfMatrix(rows - 1, cols - 1, matrix, dpMatrix);
    }

    private static void createInsideOfMatrix(int lastRow, int lastCol, int[][] matrix, int[][] dpMatrix) {
        for (int i = lastRow - 1; i >= 0; i--) {
            for (int j = lastCol - 1; j >= 0; j--) {
                dpMatrix[i][j] = Math.max(dpMatrix[i+1][j] + matrix[i][j],
                        dpMatrix[i][j+1] + matrix[i][j]);
            }
        }
    }

    private static void createFirstCol(int lastRow, int lastCol, int[][] matrix, int[][] dpMatrix) {
        for (int i = lastRow - 1; i >= 0; i--) {
            dpMatrix[i][lastCol] = dpMatrix[i+1][lastCol] + matrix[i][lastCol];
        }
    }

    private static void createFirstRow(int lastCol, int lastRow, int[][] matrix, int[][] dpMatrix) {
        dpMatrix[lastRow][lastCol] = matrix[lastRow][lastCol];

        for (int i = lastCol-1; i >= 0; i--) {
            dpMatrix[lastRow][i] = dpMatrix[lastRow][i+1] + matrix[lastRow][i];
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
