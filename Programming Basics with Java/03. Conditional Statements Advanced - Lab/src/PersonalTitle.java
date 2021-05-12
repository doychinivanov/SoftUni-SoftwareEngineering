import java.util.Scanner;

public class PersonalTitle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double age = Double.parseDouble(scan.nextLine());
        String sex = scan.nextLine();
        String title = "";

        if(sex.equals("f")){
            if(age >= 16){
                title = "Ms.";
            } else {
                title = "Miss";
            }
        } else if(sex.equals("m")){
            if(age >= 16){
                title = "Mr.";
            } else {
                title = "Master";
            }
        }

        System.out.println(title);
    }
}
