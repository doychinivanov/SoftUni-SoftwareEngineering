import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        readMatrix(reader, rows, matrix);

        char replacement = reader.readLine().charAt(0);

        int[] coordinatesOfTargetSymbol = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowOfTargetSymbol = coordinatesOfTargetSymbol[0];
        int colOfTargetSymbol = coordinatesOfTargetSymbol[1];

        char targetSymbol = matrix[rowOfTargetSymbol][colOfTargetSymbol];

        replaceChars(rowOfTargetSymbol, colOfTargetSymbol, matrix, targetSymbol, replacement);

        printMatrix(rows, cols, matrix);
    }

    private static void replaceChars(int curRow, int curCol, char[][] matrix, char targetSymbol, char replacement) {
        if (isOutOfBounds(matrix, curRow, curCol) || matrix[curRow][curCol] != targetSymbol) return;

        matrix[curRow][curCol] = replacement;

        replaceChars(curRow, curCol + 1, matrix, targetSymbol, replacement);
        replaceChars(curRow + 1, curCol, matrix, targetSymbol, replacement);
        replaceChars(curRow, curCol - 1, matrix, targetSymbol, replacement);
        replaceChars(curRow - 1, curCol, matrix, targetSymbol, replacement);
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1;
    }

    private static void printMatrix(int rows, int cols, char[][] matrix) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.append(matrix[i][j]);
            }

            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

    private static void readMatrix(BufferedReader reader, int rows, char[][] matrix) throws IOException {
        for (int i = 0; i < rows; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }
    }
}
