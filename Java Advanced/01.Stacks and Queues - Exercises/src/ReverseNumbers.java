import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = createStack(numbers);

        printStack(stack);
    }

    private static ArrayDeque<Integer> createStack(int[] numbers) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int n: numbers) {
            stack.push(n);
        }

        return stack;
    }


    private static void printStack(ArrayDeque<Integer> stack) {
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()){
            result.append(stack.pop()).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
