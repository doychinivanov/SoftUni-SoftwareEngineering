import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        String input = scan.nextLine();

        setGuestList(scan, vip, regular, input);

        input = scan.nextLine();

        checkComingGuestInGuestList(scan, vip, regular, input);

        System.out.println(vip.size() + regular.size());

        printSetIfNotEmpty(vip);
        printSetIfNotEmpty(regular);
    }

    private static void printSetIfNotEmpty(TreeSet<String> set) {
        if(!set.isEmpty()){
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }

    private static void checkComingGuestInGuestList(Scanner scan, TreeSet<String> vip, TreeSet<String> regular, String input) {
        while(!input.equals("END")){
            if(Character.isDigit(input.charAt(0))){
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scan.nextLine();
        }
    }

    private static void setGuestList(Scanner scan, TreeSet<String> vip, TreeSet<String> regular, String input) {
        while(!input.equals("PARTY")){

            if(Character.isDigit(input.charAt(0))){
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scan.nextLine();
        }
    }
}
