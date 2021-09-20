import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readMatrix(rows, columns, "\\s+", scan);
        char[][] secondMatrix = readMatrix(rows, columns, "\\s+", scan);

        char[][] intersectionMatrix = createIntersectionMatrix(firstMatrix, secondMatrix);

        printMatrix(intersectionMatrix);
    }

    public static char[][] createIntersectionMatrix(char[][] firstMatrix, char[][] secondMatrix){
        char[][] interSectionMatrix = new char[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if(firstMatrix[i][j] == secondMatrix[i][j]){
                    interSectionMatrix[i][j] = firstMatrix[i][j];
                } else {
                    interSectionMatrix[i][j] = '*';
                }
            }
        }

        return  interSectionMatrix;
    }

    public static char[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] currentRow = readArray(columns, scan);

            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        return matrix;
    }

    public static char[] readArray(int columns, Scanner scan){
        char[] arrResult = new char[columns];

        for (int i = 0; i < columns; i++) {
            arrResult[i] = scan.next().charAt(0);
        }

        return arrResult;
    }

    public static void printMatrix(char [][] matrix){
        ArrayList<String> matrixRows = new ArrayList<>();

        for (char[] chars : matrix) {
            StringBuilder currentRow = new StringBuilder();

            for (int j = 0; j < chars.length; j++) {
                currentRow.append(chars[j]).append(" ");
            }

            matrixRows.add(currentRow.toString());
        }

        System.out.println(String.join("\n", matrixRows));
    }
}
