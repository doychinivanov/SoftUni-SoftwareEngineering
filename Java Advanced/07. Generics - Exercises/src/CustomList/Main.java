package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        CustomList<String> list = new CustomList<String>();
        String input = scan.nextLine();

        while(!input.equals("END")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            executeCommand(list, tokens, command);

            input = scan.nextLine();
        }
    }

    private static void executeCommand(CustomList<String> list, String[] tokens, String command) {
        if(command.equals("Add")){
            list.add(tokens[1]);
        } else if(command.equals("Max")){
            System.out.println(list.getMax());
        } else if (command.equals("Min")){
            System.out.println(list.getMin());
        } else if(command.equals("Swap")){
            list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        } else if(command.equals("Contains")){
            System.out.println(list.contains(tokens[1]));
        } else if(command.equals("Print")){
            list.forEach(System.out::println);
        } else if(command.equals("Greater")){
            System.out.println(list.countGreaterThan(tokens[1]));
        } else if(command.equals("Remove")){
            list.remove(Integer.parseInt(tokens[1]));
        } else if(command.equals("Sort")){
            Sorter.sort(list);
        }
    }
}
