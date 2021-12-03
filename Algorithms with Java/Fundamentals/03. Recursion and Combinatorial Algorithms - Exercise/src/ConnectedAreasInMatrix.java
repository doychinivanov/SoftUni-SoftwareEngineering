import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInMatrix {
    private static char[][] matrix;
    private static List<int[]> areas = new ArrayList<>();

    private static char wall = '*';
    private static char free = '-';
    private static char taken = 'V';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        matrix = new char[rows][cols];

        readMatrix(reader, rows);

        for (int r = 0; r < matrix.length ; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == free) {
                    areas.add(new int[] {r, c, 0});
                    findAreas(r, c);
                }
            }
        }

        System.out.println("Total areas found: " + areas.size());
        AtomicInteger counter = new AtomicInteger(1);

        areas
                .stream()
                .sorted((a, b) -> Integer.compare(b[2], a[2]))
                .forEach(area -> {
                    System.out.println(String.format("Area #%d at (%d, %d), size: %d", counter.getAndIncrement(), area[0], area[1], area[2]));
                });
    }

    private static void findAreas(int row, int col) {
        if (isOutOfBounds(row, col) || isNotTraversable(row, col)) return;

        matrix[row][col] = taken;

        areas.get(areas.size() - 1)[2]++;

        findAreas(row + 1, col);
        findAreas(row, col + 1);
        findAreas(row - 1, col);
        findAreas(row, col - 1);

    }

    private static boolean isNotTraversable(int row, int col) {
        return matrix[row][col] == taken || matrix[row][col] == wall;
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void readMatrix(BufferedReader reader, int rows) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }
    }
}
