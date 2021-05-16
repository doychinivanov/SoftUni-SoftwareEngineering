import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        int pieces = width * height;

        while(pieces > 0){
            String input = scan.nextLine();

            if(input.equals("STOP")){
                break;
            }

            pieces -= Integer.parseInt(input);
        }

        if(pieces > 0){
            System.out.printf("%d pieces are left.", pieces);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieces));
        }
    }
}