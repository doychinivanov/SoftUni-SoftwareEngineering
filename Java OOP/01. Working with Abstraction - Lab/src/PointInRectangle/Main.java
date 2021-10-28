package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Point A = new Point(coordinates[0], coordinates[1]);
        Point B = new Point(coordinates[2], coordinates[3]);

        Rectangle rect = new Rectangle(A, B);

        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            int[] singlePoint = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            Point P = new Point(singlePoint[0], singlePoint[1]);

            boolean isWithin = rect.contains(P);

            System.out.println(isWithin);
        }
    }
}
