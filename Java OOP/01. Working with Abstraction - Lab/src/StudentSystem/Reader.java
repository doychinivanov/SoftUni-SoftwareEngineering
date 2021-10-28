package StudentSystem;

import java.util.Scanner;

public class Reader {
    public static Scanner scan = new Scanner (System.in);

    public static String[] readStringArr(String delimiter){
        return scan.nextLine().split(delimiter);
    }
}
