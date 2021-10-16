package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        scan.nextLine();

        Lake<Integer> lake = new Lake<>(numbers);

        printFrogJumps(lake);
    }

    public static void printFrogJumps(Lake<Integer> lake){
        List<String> result = new ArrayList<>();

        lake.forEach(x -> result.add(String.valueOf(x)));

        System.out.println(String.join(", ", result));
    }
}
