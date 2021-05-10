import java.util.Scanner;

public class ProjectCreation {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int projects = Integer.parseInt(scan.nextLine());
        int time = projects * 3;

        System.out.println("The architect " + name +  " will need " + time + " hours to complete " + projects + " project/s.");
    }
}
