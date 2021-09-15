import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        ArrayDeque<String> backHistory = new ArrayDeque<>();

        String input = scan.nextLine();

        while(!input.equals("Home")){

            if(input.equals("forward")){
                handleForwardMovement(backHistory ,forwardHistory);
            } else if (input.equals("back")){
                handleBackwardMovement(backHistory, forwardHistory);
            } else {
                backHistory.push(input);
                forwardHistory.clear();
                System.out.println(backHistory.peek());
            }

            input = scan.nextLine();
        }
    }

    private static void handleBackwardMovement(ArrayDeque<String> backHistory, ArrayDeque<String> forwardHistory) {
        if(backHistory.size() > 1){
            String previousPage = backHistory.pop();
            forwardHistory.addFirst(previousPage);

            System.out.println(backHistory.peek());
        } else {
            System.out.println("no previous URLs");
        }
    }

    private static void handleForwardMovement(ArrayDeque<String> backHistory, ArrayDeque<String> forwardHistory) {
        if(forwardHistory.size() > 0){
            String forwardPage = forwardHistory.poll();
            backHistory.push(forwardPage);
            System.out.println(forwardPage);
        } else {
            System.out.println("no next URLs");
        }
    }
}
