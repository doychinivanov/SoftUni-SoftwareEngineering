import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int numberOfCommands = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

           if(commands[0] == 1){
               stack.push(commands[1]);
           } else if(commands[0] == 2){
                stack.pop();
           } else if(commands[0] == 3){
               System.out.println(stack.stream().mapToInt(x->x).max().orElse(0));
           }
        }

    }
}
