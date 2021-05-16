import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstLine = scan.nextLine().split(" ");
        String[] secondLine = scan.nextLine().split(" ");

        for (String word1:secondLine){
            for(String word2 : firstLine){
                if(word1.equals(word2)){
                    System.out.print(word1 + " ");
                    break;
                }
            }
        }
    }
}