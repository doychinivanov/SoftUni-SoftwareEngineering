import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayDeque<Integer> indexesOfOpenedBrackets = new ArrayDeque<>();
        String expression = scan.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);

            if(currentSymbol == '('){
                indexesOfOpenedBrackets.push(i);
            }

            if(currentSymbol == ')'){
                int startOfExpression = indexesOfOpenedBrackets.pop();
                String innerExpression = expression.substring(startOfExpression, i+1);

                System.out.println(innerExpression);
            }
        }
    }
}
