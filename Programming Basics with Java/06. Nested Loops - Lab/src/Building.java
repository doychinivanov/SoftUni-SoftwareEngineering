import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int floors = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());
        int topFloor = floors;

        for (int i = floors; i >= 1 ; i--) {
            String output = "";
            for (int j = 0; j < rooms; j++) {
                if(topFloor == floors){
                    output += String.format("L%d%d ", i, j);
                } else if(i % 2 == 0){
                    output += String.format("O%d%d ", i, j);
                } else {
                    output += String.format("A%d%d ", i, j);
                }
            }
            
            topFloor--;
            System.out.println(output);
        }
    }
}
