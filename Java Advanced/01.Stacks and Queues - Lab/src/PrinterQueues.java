import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueues {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String input = scan.nextLine();

        while(!input.equals("print")){

            if(input.equals("cancel")){
                handleCancelCommand(printerQueue);
            } else {
                printerQueue.offer(input);
            }

            input = scan.nextLine();
        }

        if(!printerQueue.isEmpty()){
            System.out.println(String.join(System.lineSeparator(), printerQueue));
        }
    }

    private static void handleCancelCommand(ArrayDeque<String> printerQueue) {
        if(printerQueue.isEmpty()){
            System.out.println("Printer is on standby");
        } else {
            System.out.printf("Canceled %s" + System.lineSeparator(), printerQueue.poll());
        }
    }
}
