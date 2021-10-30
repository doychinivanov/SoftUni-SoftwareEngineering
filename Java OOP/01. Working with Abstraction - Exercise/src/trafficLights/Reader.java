package trafficLights;

import java.util.Scanner;

public class Reader {
    public static Scanner scan = new Scanner (System.in);

    public static String[] readStringArrFromConsole(String delimiter){
        return scan.nextLine().split(delimiter);
    }

    public static String readLineFromConsole(){
        return scan.nextLine();
    }
}
