import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] operands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numsToRead = operands[0];
        int numsToPoll = operands[1];
        int numToCheck = operands[2];

        fillStack(scan, queue, numsToRead);
        popFromStack(queue, numsToPoll);

        if (queue.contains(numToCheck)){
            System.out.println("true");
        } else {
            System.out.println(queue.stream().mapToInt(x->x).min().orElse(0));
        }

    }

    private static void popFromStack(ArrayDeque<Integer> stack, int numsToPop) {
        IntStream.range(0, numsToPop).forEach(x -> stack.poll());
    }

    private static void fillStack(Scanner scan, ArrayDeque<Integer> stack, int numsToRead) {
        IntStream.range(0, numsToRead).mapToObj(i -> scan.nextInt()).forEach(stack::offer);
    }
}
