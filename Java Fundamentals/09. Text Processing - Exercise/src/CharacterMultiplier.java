import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputs = scan.nextLine().split("\\s+");

        System.out.println(multiplyChars(inputs[0], inputs[1]));
    }

    public static long multiplyChars (String first, String second){
        long sum = 0;
        String shorter = "";
        String longer = "";

        if(first.length() > second.length()){
            longer = first;
            shorter = second;
        } else {
            longer = second;
            shorter = first;
        }

        for (int i = 0; i < shorter.length(); i++) {
            sum += (long) shorter.charAt(i) * longer.charAt(i);
        }

        for (int i = shorter.length(); i < longer.length(); i++) {
            sum += longer.charAt(i);
        }

        return sum;
    }
}