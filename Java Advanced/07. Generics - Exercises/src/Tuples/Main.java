package Tuples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Tuple> tuples = new ArrayList<>();

        String[] personDetails = scan.nextLine().split("\\s+");
        String[] personBeers = scan.nextLine().split("\\s+");
        String[] someShit = scan.nextLine().split("\\s+");

        tuples.add(new Tuple(personDetails[0] + " " + personDetails[1], personDetails[2]));
        tuples.add(new Tuple(personBeers[0], Integer.parseInt(personBeers[1])));
        tuples.add(new Tuple(Integer.parseInt(someShit[0]), Double.parseDouble(someShit[1])));

        tuples.forEach(tuple -> System.out.println(tuple.getItem1() + " -> " + tuple.getItem2()));
    }
}
