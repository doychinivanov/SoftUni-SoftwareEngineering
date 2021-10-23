import java.util.ArrayList;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scan.nextLine());
        char[][] matrix = readMatrix(matrixSize, matrixSize, "", scan);
        int[] playerCoordinates = findPlayer(matrix);
        int eatenCheese = 0;
        boolean leftTheMatrix = false;

        String command = scan.nextLine();

        while(!command.equals("end")){
            if(command.equals("up")){
                int newRow = playerCoordinates[0] - 1;
                int newCol = playerCoordinates[1];

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                if(isBonus(matrix, newRow, newCol)){
                    matrix[newRow][newCol] = '-';
                    newRow -= 1;
                }

                if(isCheese(matrix, newRow, newCol)){
                    eatenCheese += 1;
                    matrix[newRow][newCol] = '-';
                }

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                playerCoordinates[0] = newRow;
            } else if(command.equals("down")){
                int newRow = playerCoordinates[0] + 1;
                int newCol = playerCoordinates[1];

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                if(isBonus(matrix, newRow, newCol)){
                    matrix[newRow][newCol] = '-';
                    newRow += 1;
                }

                if(isCheese(matrix, newRow, newCol)){
                    eatenCheese += 1;
                    matrix[newRow][newCol] = '-';
                }

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                playerCoordinates[0] = newRow;
            } else if(command.equals("left")){
                int newRow = playerCoordinates[0] ;
                int newCol = playerCoordinates[1] - 1;

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                if(isBonus(matrix, newRow, newCol)){
                    matrix[newRow][newCol] = '-';
                    newCol -= 1;
                }

                if(isCheese(matrix, newRow, newCol)){
                    eatenCheese += 1;
                    matrix[newRow][newCol] = '-';
                }

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                playerCoordinates[1] = newCol;
            } else if(command.equals("right")){
                int newRow = playerCoordinates[0];
                int newCol = playerCoordinates[1] + 1;

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                if(isBonus(matrix, newRow, newCol)){
                    matrix[newRow][newCol] = '-';
                    newCol += 1;
                }

                if(isCheese(matrix, newRow, newCol)){
                    eatenCheese += 1;
                    matrix[newRow][newCol] = '-';
                }

                if(isOutOfBound(matrix, newRow, newCol)){
                    leftTheMatrix = handleOutOfBoundExeption();
                    break;
                }

                playerCoordinates[1] = newCol;
            }

            command = scan.nextLine();
        }

        if(leftTheMatrix){
            matrix[playerCoordinates[0]][playerCoordinates[1]] = '-';
        } else {
            matrix[playerCoordinates[0]][playerCoordinates[1]] = 'M';
        }
        printOutput(matrix, eatenCheese);
    }

    private static boolean handleOutOfBoundExeption() {
        System.out.println("Where is the mouse?");
        return true;
    }

    public static boolean isCheese(char[][] matrix, int row, int col){
        return matrix[row][col] == 'c';
    }

    private static void printOutput(char[][] matrix, int eatenCheese) {
        if(eatenCheese >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!" + System.lineSeparator(), eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more." + System.lineSeparator(), 5 - eatenCheese);
        }

        printMatrix(matrix);
    }

    public static boolean isOutOfBound(char[][] matrix, int row, int col){

        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    public static boolean isBonus(char[][] matrix, int row, int col){
        return matrix[row][col] == 'B';
    }

    public static int[] findPlayer(char[][] matrix){
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col] == 'M'){
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        matrix[coordinates[0]][coordinates[1]] = '-';

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
