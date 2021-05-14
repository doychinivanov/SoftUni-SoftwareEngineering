import java.util.Scanner;

public class MovingOut {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        int freeSpace = width * length * height;
        boolean isFull = false;
        String input = scan.nextLine();

        while (input.equals("Done") == false){
            int volume = Integer.parseInt(input);
            freeSpace -= volume;

            if(freeSpace <= 0){
                isFull = true;
                break;
            }

            input = scan.nextLine();
        }

        if(isFull){
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(freeSpace));
        } else {
            System.out.printf("%d Cubic meters left.", freeSpace);
        }

    }
}