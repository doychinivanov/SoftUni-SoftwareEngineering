package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static Scanner scan = new Scanner (System.in);

    public static int[] readIntArray(String delimiter){
        return Arrays.stream(Reader.readLine().split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] readIntArrayFromString(String text, String delimiter){
        return Arrays.stream(text.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static String readLine(){
        return scan.nextLine();
    }
}
