import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixData = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixData[0];
        int cols = matrixData[1];

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String input = scan.nextLine();

        while(input.equals("Nuke it from orbit") == false){
            int[] commands = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int rowCoordinates = commands[0];
            int columnCoordinates = commands[1];
            int radius = commands[2];

            nukeMatrix(matrix, rowCoordinates, columnCoordinates, radius);
            matrix.removeIf(List::isEmpty);

            input = scan.nextLine();
        }

        printListMatrix(matrix);
    }

    public static boolean isInMatrix(ArrayList<ArrayList<Integer>> matrix, int rows, int cols){
        return rows >= 0 && rows < matrix.size() && cols >= 0 && cols < matrix.get(rows).size();
    }

    public static void nukeMatrix(ArrayList<ArrayList<Integer>> matrix, int rowCoordinates, int columnCoordinates, int radius){
        for (int currentRow = rowCoordinates - radius; currentRow <= rowCoordinates + radius ; currentRow++) {
            if(isInMatrix(matrix, currentRow, columnCoordinates) && currentRow != rowCoordinates){
                matrix.get(currentRow).remove(columnCoordinates);
            }

        }

        for (int currentColumn = columnCoordinates + radius; currentColumn >= columnCoordinates - radius; currentColumn--) {
            if(isInMatrix(matrix, rowCoordinates, currentColumn)){
                matrix.get(rowCoordinates).remove(currentColumn);
            }

        }
    }

    public static void fillMatrix(ArrayList<ArrayList<Integer>> matrix, int rows, int cols){
        int value = 1;

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            matrix.add(new ArrayList<>());
            for (int currentColumn = 0; currentColumn < cols; currentColumn++) {
                matrix.get(currentRow).add(value);
                value++;
            }
        }
    }

    public static void printListMatrix(ArrayList<ArrayList<Integer>> matrix){
        ArrayList<String> result = new ArrayList<>();

        matrix.forEach(row -> {
            StringBuilder currentRow = new StringBuilder();
            row.forEach(number -> currentRow.append(number).append(" "));

            result.add(currentRow.toString());
        });

        System.out.println(String.join("\n", result));
    }
}
