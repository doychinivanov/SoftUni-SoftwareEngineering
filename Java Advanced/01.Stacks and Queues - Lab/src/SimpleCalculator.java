import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputData = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = createReversedStack(inputData);


        while (stack.size() != 1){
            int firstNumber = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            int result = operand.equals("+") ? firstNumber + secondNumber
                    : firstNumber - secondNumber;

            stack.push(Integer.toString(result));
        }

        System.out.println(stack.peek());

    }

    public static ArrayDeque<String> createReversedStack(String[] inputData){
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = inputData.length-1; i >= 0 ; i--) {
            stack.push(inputData[i]);
        }

        return stack;
    }
}
