package ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Object[] initialArray = Arrays.stream(scan.nextLine().split("\\s+")).skip(1).toArray();
        String[] people = Arrays.copyOf(initialArray, initialArray.length, String[].class);

        ListIterator<String> data = new ListIterator<>(people);

        String command = scan.nextLine();

        while(!command.equals("END")){

            if(command.equals("HasNext")){
                System.out.println(data.hasNext());
            } else if(command.equals("Move")){
                System.out.println(data.move());
            } else if(command.equals("Print")){
                try{
                    data.print();
                } catch (Exception e){
                    System.out.println("Invalid Operation!");
                }
            } else if(command.equals("PrintAll")){
                data.printAll();
            }

            command = scan.nextLine();
        }
    }
}
