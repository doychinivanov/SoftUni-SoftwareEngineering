import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayList<String> allowedParentheses = new ArrayList<>(Arrays.asList("{", "[", "("));
        ArrayDeque<String> openParentheses = new ArrayDeque<>();

        String parenthesesExpression = scan.nextLine();
        boolean parenthesesAreClosed = true;

        for (int i = 0; i < parenthesesExpression.length(); i++) {
            String currentSymbol = Character.toString(parenthesesExpression.charAt(i));

            if(allowedParentheses.contains(currentSymbol)){
                openParentheses.push(currentSymbol);
            } else {
                parenthesesAreClosed = handleClosingParenthesis(openParentheses, currentSymbol, parenthesesAreClosed);
            }

            if(!parenthesesAreClosed) break;
        }

        printResult(parenthesesAreClosed);
    }

    public static boolean handleClosingParenthesis(ArrayDeque<String> openParentheses, String currentSymbol, boolean parenthesesAreClosed){
        if(openParentheses.size() > 0){
            String parenthesesThatMustBeClosed = openParentheses.pop();

            if(currentSymbol.equals(getOpposingParentheses(parenthesesThatMustBeClosed)) == false){
                parenthesesAreClosed = false;
            }
        } else {
            parenthesesAreClosed = false;
        }

        return parenthesesAreClosed;
    }

    public static String getOpposingParentheses(String openParentheses){
        String closingParentheses = "";

        if(openParentheses.equals("(")){
            closingParentheses = ")";
        } else if(openParentheses.equals("[")){
            closingParentheses = "]";
        } else if(openParentheses.equals("{")){
            closingParentheses = "}";
        }

        return closingParentheses;
    }

    public static void printResult(boolean parenthesesAreClosed){
        if(parenthesesAreClosed){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
