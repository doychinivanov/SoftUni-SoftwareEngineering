import java.util.ArrayList;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",");
        char[][] matrix = readMatrix(matrixSize, matrixSize, "\\s", scan);
        int[] initialCoordinates = findStartingCoordinates(matrix);

        boolean gameIsEnded = false;

        int totalDetonatedBombs = 0;


        for (String currentCommand: commands) {
            if(currentCommand.equals("down")){
                int newRow = initialCoordinates[0] + 1;
                int newCol = initialCoordinates[1];

                if(isOutOfBound(matrix, newRow, newCol)){
                    continue;
                }

                if(isATrap(matrix, newRow, newCol)){
                    gameIsEnded = true;
                    break;
                }

                if(isABomb(matrix, newRow, newCol)){
                    totalDetonatedBombs = detonateBomb(matrix, totalDetonatedBombs, newRow, newCol);
                }

                initialCoordinates[0] = newRow;

            } else if (currentCommand.equals("up")){
                int newRow = initialCoordinates[0] - 1;
                int newCol = initialCoordinates[1];

                if(isOutOfBound(matrix, newRow, newCol)){
                    continue;
                }

                if(isATrap(matrix, newRow, newCol)){
                    gameIsEnded = true;
                    break;
                }

                if(isABomb(matrix, newRow, newCol)){
                    totalDetonatedBombs = detonateBomb(matrix, totalDetonatedBombs, newRow, newCol);
                }

                initialCoordinates[0] = newRow;

            } else if (currentCommand.equals("left")){
                int newRow = initialCoordinates[0];
                int newCol = initialCoordinates[1] - 1;

                if(isOutOfBound(matrix, newRow, newCol)){
                    continue;
                }

                if(isATrap(matrix, newRow, newCol)){
                    gameIsEnded = true;
                    break;
                }

                if(isABomb(matrix, newRow, newCol)){
                    totalDetonatedBombs = detonateBomb(matrix, totalDetonatedBombs, newRow, newCol);
                }

                initialCoordinates[1] = newCol;

            } else if (currentCommand.equals("right")){
                int newRow = initialCoordinates[0];
                int newCol = initialCoordinates[1] + 1;

                if(isOutOfBound(matrix, newRow, newCol)){
                    continue;
                }

                if(isATrap(matrix, newRow, newCol)){
                    gameIsEnded = true;
                    break;
                }

                if(isABomb(matrix, newRow, newCol)){
                    totalDetonatedBombs = detonateBomb(matrix, totalDetonatedBombs, newRow, newCol);
                }

                initialCoordinates[1] = newCol;

            }
        }

        int leftBombs = findAllLeftBombs(matrix);

        if(leftBombs == 0){
            System.out.println("Congratulations! You found all bombs!");
        } else if(gameIsEnded){
            System.out.printf("END! %d bombs left on the field", leftBombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", leftBombs, initialCoordinates[0], initialCoordinates[1]);
        }
    }

    private static int findAllLeftBombs(char[][] matrix){
        int leftBombs = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    leftBombs++;
                }
            }
        }

        return leftBombs;
    }

    private static int detonateBomb(char[][] matrix, int totalDetonatedBombs, int newRow, int newCol) {
        totalDetonatedBombs += 1;
        matrix[newRow][newCol] = '+';
        System.out.println("You found a bomb!");
        return totalDetonatedBombs;
    }

    public static boolean isABomb(char[][] matrix, int row, int col){
        return matrix[row][col] == 'B';
    }

    public static boolean isATrap(char[][] matrix, int row, int col){
        return matrix[row][col] == 'e';
    }

    public static boolean isOutOfBound(char[][] matrix, int row, int col){
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    public static int[] findStartingCoordinates(char[][] matrix){
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        return coordinates;
    }

    public static char[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] currentRow = readArray(scan, delimiter);

            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        return matrix;
    }

    public static char[] readArray(Scanner scan, String delimiter){
        return String.join("", scan.nextLine().split(delimiter)).toCharArray();
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
