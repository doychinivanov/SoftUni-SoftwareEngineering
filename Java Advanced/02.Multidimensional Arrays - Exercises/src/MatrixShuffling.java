import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixData = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixData[0];
        int columns = matrixData[1];

        String[][] matrix = readMatrix(rows, columns, "\\s+", scan);

        String input = scan.nextLine();

        while(input.equals("END") == false){

            if(!validateInput(input, matrix, rows, columns)){
                System.out.println("Invalid input!");
            } else {
                swapElementsInMatrix(matrix, input);
                printMatrix(matrix);
            }

            input = scan.nextLine();
        }

    }

    private static void swapElementsInMatrix(String[][] matrix, String command) {
        String[] commandData = command.split("\\s+");

        int firstRow = Integer.parseInt(commandData[1]);
        int secondRow = Integer.parseInt(commandData[3]);
        int firstColumn = Integer.parseInt(commandData[2]);
        int secondColumn = Integer.parseInt(commandData[4]);

        String firstElement = matrix[firstRow][firstColumn];
        String secondElement = matrix[secondRow][secondColumn];

        matrix[firstRow][firstColumn] = secondElement;
        matrix[secondRow][secondColumn] = firstElement;
    }

    private static boolean validateInput(String command, String[][] matrix, int rows, int columns) {
        String[] commandData = command.split("\\s+");

        if(!commandData[0].equals("swap")) return false;

        if (commandData.length != 5) return false;

        int firstRow = Integer.parseInt(commandData[1]);
        int secondRow = Integer.parseInt(commandData[3]);
        int firstColumn = Integer.parseInt(commandData[2]);
        int secondColumn = Integer.parseInt(commandData[4]);

        if(firstRow < 0 || firstRow >= rows ||
                secondRow < 0 || secondRow >= rows ||
                firstColumn < 0 || firstColumn >= columns ||
                secondColumn < 0 || secondColumn >= columns) return false;

        return true;
    }

    public static String[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] currentRow = readArray(scan, delimiter);

            matrix[i] = currentRow;
        }

        return matrix;
    }

    public static String[] readArray(Scanner scan, String delimiter){
        return scan.nextLine().split(delimiter);
    }

    public static void printMatrix(String [][] matrix){
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
