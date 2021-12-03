import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] someArray = reader.readLine().split("\\s+");
        String[] reversedArray = new String[someArray.length];

        fillReversedArray(someArray, reversedArray, someArray.length - 1, 0);

        System.out.println(String.join(" ", reversedArray));
    }

    private static void fillReversedArray(String[] someArray, String[] reversedArray, int index, int reversedArrIndex) {
        if(index < 0) return;

        reversedArray[reversedArrIndex] = someArray[index];
        fillReversedArray(someArray, reversedArray, index -1, reversedArrIndex +1 );
    }
}
