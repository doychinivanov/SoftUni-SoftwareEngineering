import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<Scanner, int[]> readIntegers = scanner -> Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Consumer<int[]> printNumbers = arr -> System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        int[] numbers = readIntegers.apply(scan);

        String input = scan.nextLine();

        while(!input.equals("end")){

            if(input.equals("print")){
                printNumbers.accept(numbers);
                input = scan.nextLine();
                continue;
            }

            Function<int[], int[]> manipulateArray = getNeededOperation(input);
            numbers = manipulateArray.apply(numbers);

            input = scan.nextLine();
        }
    }

    private static Function<int[], int[]> getNeededOperation(String command){
        if(command.equals("add")){
            return arr -> Arrays.stream(arr).map(x -> x + 1).toArray();
        }else if(command.equals("multiply")){
            return arr -> Arrays.stream(arr).map(x -> x * 2).toArray();
        } else {
            return arr -> Arrays.stream(arr).map(x -> x - 1).toArray();
        }
    }
}
