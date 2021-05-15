import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String book = scan.nextLine();
        int count = 0;
        boolean isFound = false;

        String input = scan.nextLine();

        while(input.equals("No More Books") == false){
            if(book.equals(input)){
                isFound = true;
                break;
            }

            count ++;
            input = scan.nextLine();
        }

        if(isFound){
            System.out.printf("You checked %d books and found it.", count);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", count);
        }
    }
}