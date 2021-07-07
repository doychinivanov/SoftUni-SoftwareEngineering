import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String[] words = scan.nextLine().split("\\s+");
        List<Double> sumOfWords = new ArrayList<>();

        for(String word: words){
            double sumOfCurrentWord = getWordSum(word);
            sumOfWords.add(sumOfCurrentWord);
        }

        System.out.printf("%.2f", sumOfWords.stream().reduce(0.0,(acc,cur)->acc+cur));
    }

    private static double getWordSum(String word) {
        double sum = 0;
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        double number = Double.parseDouble(word.substring(1, word.length()-1));

        if(Character.isUpperCase(firstLetter)){
            sum += number / (firstLetter - 64);
        } else {
            sum += number * (firstLetter - 96);
        }

        if(Character.isUpperCase(lastLetter)){
            sum -= (lastLetter - 64);
        } else {
            sum += (lastLetter - 96);
        }

        return sum;
    }
}
