import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] inputEquation = scan.nextLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> polishNotation = new ArrayDeque<>();
        Map<String,Integer> priorities = new HashMap<>();
        setPriorities(priorities);

        for (String element: inputEquation) {
            try{
                double currentNumber = Double.parseDouble(element);
                polishNotation.offer(element);
            } catch(Exception err){
                String regex = "[a-z]";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(element);

                if(matcher.find()){
                    polishNotation.offer(element);
                } else if (element.equals("(")){
                    operators.push(element);
                } else if (element.equals(")")){
                    migrateOperandsInsideParantheses(operators, polishNotation);
                } else {
                    while (!operators.isEmpty() && priorities.get(operators.peek()) >= priorities.get(element)) {
                        polishNotation.offer(operators.pop());
                    }
                    operators.push(element);
                }

            }
        }

        addLeftOperantsToPolishNotation(operators, polishNotation);

        System.out.println(String.join(" ", polishNotation));
    }

    private static void setPriorities(Map<String, Integer> priorities) {
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);
    }

    private static void addLeftOperantsToPolishNotation(ArrayDeque<String> operators, ArrayDeque<String> polishNotation) {
        while (operators.isEmpty() == false){
            polishNotation.offer(operators.pop());
        }
    }

    private static void migrateOperandsInsideParantheses(ArrayDeque<String> operators, ArrayDeque<String> polishNotation) {
        String elementInsideParentheses = operators.pop();
        while (elementInsideParentheses.equals("(") == false){
            polishNotation.offer(elementInsideParentheses);
            elementInsideParentheses = operators.pop();
        }
    }
}
