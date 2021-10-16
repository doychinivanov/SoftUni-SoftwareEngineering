package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int[] elements = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .skip(1)
                .mapToInt(x -> Integer.parseInt(x.split(",")[0]))
                .toArray();

        fillStack(stack, elements);

        String command = scan.nextLine();

        while(!command.equals("END")){

            if(command.equals("Pop")){
                try{
                    stack.pop();
                } catch (Exception e){
                    System.out.println("No elements");
                }
            } else {
                int[] newElements = Arrays.stream(command.split("\\s+"))
                        .skip(1)
                        .mapToInt(x -> Integer.parseInt(x.split(",")[0]))
                        .toArray();

                fillStack(stack, newElements);
            }

            command = scan.nextLine();
        }

        stack.printStackTwice();
    }

    private static void fillStack(Stack<Integer> stack, int[] elements) {
        for (int n: elements) {
            stack.push(n);
        }
    }
}
