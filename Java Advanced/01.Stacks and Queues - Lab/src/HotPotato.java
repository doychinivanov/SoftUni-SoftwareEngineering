import java.util.*;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int rounds = Integer.parseInt(scan.nextLine());

        while(queue.size() > 1){

            for (int i = 1; i < rounds; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }

            System.out.printf("Removed %s" + System.lineSeparator(), queue.poll());
        }

        System.out.printf("Last is %s", queue.peek());
    }
}
