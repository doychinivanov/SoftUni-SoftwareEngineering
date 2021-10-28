package RhombusOfStars;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rhombusSize = Integer.parseInt(scan.nextLine());

        System.out.println(buildRhombus(rhombusSize));
    }

    private static String buildRhombus(int size){
        return  createHalfRhombus(1, size, 1, size) +
                createHalfRhombus(size-1, 1, -1, size);
    }

    private static String createHalfRhombus(int start, int end, int step, int size){
        StringBuilder result = new StringBuilder();

        Predicate<Integer> determineLoopCondition = iter -> {
            if(step > 0){
                return iter <= end;
            }

            return iter >= end;
        };

        for (int i = start; determineLoopCondition.test(i); i += step) {
            result.append(printLine(size - i, i)).append(System.lineSeparator());
        }

        return result.toString();

    }

    private static String printLine(int spaces, int stars){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < spaces; i++) {
            result.append(" ");
        }

        for (int i = 0; i < stars; i++) {
            result.append("*").append(" ");
        }

        return result.toString();
    }
}
