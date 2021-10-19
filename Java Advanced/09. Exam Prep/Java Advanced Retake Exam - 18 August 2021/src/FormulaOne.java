import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scan.nextLine());
        int commandCount = Integer.parseInt(scan.nextLine());

        char[][] matrix = readMatrix(matrixSize, matrixSize, "", scan);
        int[] playerCoordinates = findPlayer(matrix);


        for (int i = 0; i < commandCount; i++) {
            String currentCommand = scan.nextLine();

            if(currentCommand.equals("down")){
                moveDown(matrix, playerCoordinates);

            } else if (currentCommand.equals("up")){
                moveUp(matrix, playerCoordinates);

            } else if (currentCommand.equals("left")){
                moveLeft(matrix, playerCoordinates);

            } else if (currentCommand.equals("right")){
                moveRight(matrix, playerCoordinates);

            }
        }

        matrix[playerCoordinates[0]][playerCoordinates[1]] = 'P';

        printOutput(matrix);
    }

    private static void printOutput(char[][] matrix) {
        if(raceIsFinished(matrix)){
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }

    private static void moveRight(char[][] matrix, int[] playerCoordinates) {
        int newRow = playerCoordinates[0];
        int newCol = playerCoordinates[1] + 1;

        if(isOutOfBound(matrix, newRow, newCol)){
            newCol = 0;
        }

        if(isATrap(matrix, newRow, newCol)){
            return;
        }

        if(isBonus(matrix, newRow, newCol)){
            newCol += 1;
        }

        if(isOutOfBound(matrix, newRow, newCol)){
            newCol = 0;
        }

        playerCoordinates[1] = newCol;
    }

    private static void moveLeft(char[][] matrix, int[] playerCoordinates) {
        int newRow = playerCoordinates[0] ;
        int newCol = playerCoordinates[1] - 1;

        if(isOutOfBound(matrix, newRow, newCol)){
            newCol= matrix.length - 1;
        }

        if(isATrap(matrix, newRow, newCol)){
            return;
        }

        if(isBonus(matrix, newRow, newCol)){
            newCol -= 1;
        }

        if(isOutOfBound(matrix, newRow, newCol)){
            newCol= matrix.length - 1;
        }

        playerCoordinates[1] = newCol;
    }

    private static void moveUp(char[][] matrix, int[] playerCoordinates) {
        int newRow = playerCoordinates[0] - 1;
        int newCol = playerCoordinates[1];

        if(isOutOfBound(matrix, newRow, newCol)){
            newRow = matrix.length - 1;
        }

        if(isATrap(matrix, newRow, newCol)){
            return;
        }

        if(isBonus(matrix, newRow, newCol)){
            newRow -= 1;
        }

        if(isOutOfBound(matrix, newRow, newCol)){
            newRow = matrix.length - 1;
        }

        playerCoordinates[0] = newRow;
    }

    private static void moveDown(char[][] matrix, int[] playerCoordinates) {
        int newRow = playerCoordinates[0] + 1;
        int newCol = playerCoordinates[1];

        if(isOutOfBound(matrix, newRow, newCol)){
            newRow = 0;
        }

        if(isATrap(matrix, newRow, newCol)){
            return;
        }

        if(isBonus(matrix, newRow, newCol)){
            newRow += 1;
        }

        if(isOutOfBound(matrix, newRow, newCol)){
            newRow = 0;
        }

        playerCoordinates[0] = newRow;
    }

    public static boolean isATrap(char[][] matrix, int row, int col){
        return matrix[row][col] == 'T';
    }

    public static boolean isBonus(char[][] matrix, int row, int col){
        return matrix[row][col] == 'B';
    }

    public static boolean isOutOfBound(char[][] matrix, int row, int col){
        boolean isOut = false;

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix.length){
            isOut = true;
        }

        return isOut;
    }

    public static boolean raceIsFinished(char[][] matrix){
        boolean result = true;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col] == 'F'){
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public static int[] findPlayer(char[][] matrix){
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col] == 'P'){
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        matrix[coordinates[0]][coordinates[1]] = '.';

        return coordinates;
    }

    public static char[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] currentRow = readArray(scan);

            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        return matrix;
    }

    public static char[] readArray(Scanner scan){
        return scan.nextLine().toCharArray();
    }

    public static void printMatrix(char [][] matrix){
        ArrayList<String> matrixRows = new ArrayList<>();

        for (char[] chars : matrix) {
            StringBuilder currentRow = new StringBuilder();

            for (int j = 0; j < chars.length; j++) {
                currentRow.append(chars[j]);
            }

            matrixRows.add(currentRow.toString());
        }

        System.out.println(String.join("\n", matrixRows));
    }
}
