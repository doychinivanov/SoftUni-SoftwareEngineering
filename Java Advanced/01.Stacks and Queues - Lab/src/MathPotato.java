import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int rounds = Integer.parseInt(scan.nextLine());
        int cyclesCount = 1;

        while(queue.size() > 1){

            for (int i = 1; i < rounds; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }

            handleCycles(queue, cyclesCount);

            cyclesCount++;
        }

        System.out.printf("Last is %s", queue.peek());
    }

    private static void handleCycles(ArrayDeque<String> queue, int cycles) {
        if(isPrime(cycles)){
            System.out.printf("Prime %s" + System.lineSeparator(), queue.peek());
        } else {
            System.out.printf("Removed %s" + System.lineSeparator(), queue.poll());
        }
    }

    static boolean isPrime(int n){
        int i,m=0,flag=0;
        m=n/2;

        if(n==0||n==1){
            return false;
        }else{
            for(i=2;i<=m;i++){
                if(n%i==0){
                    flag=1;
                    return false;
                }
            }
            return true;
        }
    }
}
