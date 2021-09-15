import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();

        String input = scan.nextLine();

        while(!input.equals("Home")){

            if(input.equals("back")){
                handleBackNavigation(history);
            } else {
                history.push(input);
                System.out.println(history.peek());
            }

            input = scan.nextLine();
        }
    }

    private static void handleBackNavigation(ArrayDeque<String> history) {
        if(history.size() > 1){
            history.pop();
            System.out.println(history.peek());
        } else {
            System.out.println("no previous URLs");
        }
    }
}
