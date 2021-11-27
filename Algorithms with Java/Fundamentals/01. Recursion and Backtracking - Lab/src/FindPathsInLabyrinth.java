import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathsInLabyrinth {
    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rowCount = Integer.parseInt(scan.nextLine());
        int colCount = Integer.parseInt(scan.nextLine());

        char[][] labyrinth = new char[rowCount][colCount];

        readMatrixFromConsole(labyrinth, scan);

        findPath(labyrinth, 0, 0, ' ');

    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {
        if(!isInBounds(labyrinth, row, col)
                || labyrinth[row][col] == 'V'
                || labyrinth[row][col] == '*') {
            return;
        }

        path.add(direction);

        if(labyrinth[row][col] == 'e') {
            printPath(path);
            path.remove(path.size() - 1);
            return;
        }

        labyrinth[row][col] = 'V';

        findPath(labyrinth, row - 1, col, 'U');
        findPath(labyrinth, row + 1, col, 'D');
        findPath(labyrinth, row, col - 1, 'L');
        findPath(labyrinth, row, col + 1, 'R');

        labyrinth[row][col] = '-';

        path.remove(path.size() - 1);

    }

    private static void printPath(List<Character> path) {
        StringBuilder result = new StringBuilder();

        path.forEach(result::append);

        System.out.println(result.toString().trim());
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
    }

    private static void readMatrixFromConsole(char[][] matrix, Scanner scan) {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }
    }
}
