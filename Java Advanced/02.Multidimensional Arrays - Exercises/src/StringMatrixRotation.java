import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rotationCommand = scan.nextLine();
        int degrees = extractDegreesFromCommand(rotationCommand);

        ArrayList<String> words = new ArrayList<>();
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

        readWordsFromConsole(scan, words);

        fillMatrix(words, matrix);

        matrix = rotateMatrix(matrix, degrees);
        printListMatrix(matrix);

    }

    public static ArrayList<ArrayList<Character>> rotateMatrix(ArrayList<ArrayList<Character>> matrix, int degrees){
        int rotationsCount = (degrees / 90) % 4;

        if(rotationsCount == 0) return matrix;

        if (rotationsCount == 1){
            matrix = rotate90Degrees(matrix);
        } else if(rotationsCount == 2 ){
            matrix = rotate180Degrees(matrix);
        } else if (rotationsCount == 3){
            matrix = rotate270Degrees(matrix);
        }

        return matrix;
    }

    private static ArrayList<ArrayList<Character>> rotate270Degrees(ArrayList<ArrayList<Character>> matrix) {
        ArrayList<ArrayList<Character>> rotatedMatrix = new ArrayList<>();
        int longestRow = findTheLongestRowInMatrix(matrix);

        for (int col = longestRow - 1; col >= 0 ; col--) {
            ArrayList<Character> newRow = new ArrayList<>();
            for (int row = 0; row < matrix.size(); row++) {
                if(matrix.get(row).size() > col){
                    newRow.add(matrix.get(row).get(col));
                } else {
                    newRow.add(' ');
                }
            }
            rotatedMatrix.add(newRow);
        }

        return rotatedMatrix;
    }

    private static ArrayList<ArrayList<Character>> rotate180Degrees(ArrayList<ArrayList<Character>> matrix) {
        ArrayList<ArrayList<Character>> rotatedMatrix = new ArrayList<>();

        for (int row = matrix.size() - 1; row >= 0 ; row--) {
            ArrayList<Character> newRow = new ArrayList<>(matrix.get(row));
            Collections.reverse(newRow);
            rotatedMatrix.add(newRow);
        }

        return rotatedMatrix;
    }

    public static ArrayList<ArrayList<Character>> rotate90Degrees(ArrayList<ArrayList<Character>> matrix){
        ArrayList<ArrayList<Character>> rotatedMatrix = new ArrayList<>();
        int longestRow = findTheLongestRowInMatrix(matrix);

        for (int col = 0; col < longestRow; col++) {
            ArrayList<Character> newRow = new ArrayList<>();
            for (int row = 0; row < matrix.size(); row++) {
                if(matrix.get(row).size() > col){
                    newRow.add(matrix.get(row).get(col));
                } else {
                    newRow.add(' ');
                }
            }

            Collections.reverse(newRow);
            rotatedMatrix.add(newRow);
        }

        return rotatedMatrix;
    }

    private static int findTheLongestRowInMatrix(ArrayList<ArrayList<Character>> matrix){
        int longestRow = matrix.stream().mapToInt(ArrayList::size).filter(list -> list >= 0).max().orElse(0);

        return longestRow;
    }

    private static int extractDegreesFromCommand(String command){
        int degrees = 0;

        String regex = "[\\d]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(command);

        if (match.find()){
            degrees = Integer.parseInt(match.group());
        }

        return degrees;
    }

    private static void fillMatrix(ArrayList<String> words, ArrayList<ArrayList<Character>> matrix) {
        words.forEach(word -> {
            ArrayList<Character> matrixRow = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                matrixRow.add(word.charAt(i));
            }

            matrix.add(matrixRow);
        });
    }

    private static void readWordsFromConsole(Scanner scan, ArrayList<String> words) {
        String input = scan.nextLine();
        while(input.equals("END") == false){
            words.add(input);
            input = scan.nextLine();
        }
    }

    public static void printListMatrix(ArrayList<ArrayList<Character>> matrix){
        ArrayList<String> result = new ArrayList<>();

        matrix.forEach(row -> {
            StringBuilder currentRow = new StringBuilder();
            row.forEach(currentRow::append);

            result.add(currentRow.toString());
        });

        System.out.println(String.join("\n", result));
    }
}
