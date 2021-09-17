import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> manipulationHistory = new ArrayDeque<>();

        String append = "1";
        String erase = "2";
        String returnElementAtGivenIndex = "3";
        String undo = "4";

        int numberOfCommands = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = scan.nextLine().split("\\s+");

            if(commands[0].equals(append)){
                manipulationHistory.push(text.toString());
                String textToBeAppended = commands[1];
                text.append(textToBeAppended);
            } else if(commands[0].equals(erase)){
                manipulationHistory.push(text.toString());
                int amountOfElementsToDelete = Integer.parseInt(commands[1]);
                String currentText = text.substring(0, text.length() - amountOfElementsToDelete);

                text.setLength(0);
                text.append(currentText);
            } else if(commands[0].equals(returnElementAtGivenIndex)){
                int indexToBeFound = Integer.parseInt(commands[1]) - 1;
                System.out.println(text.charAt(indexToBeFound));
            } else if(commands[0].equals(undo)){
                text.setLength(0);
                text.append(manipulationHistory.pop());
            }
        }
    }
}
