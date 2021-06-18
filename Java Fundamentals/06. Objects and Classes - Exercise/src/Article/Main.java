package article;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] inputData = scan.nextLine().split(", ");
        Article newArticle = new Article(inputData[0], inputData[1], inputData[2]);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split(": ");
            String command = commands[0];
            String newData = commands[1];

            if(command.equals("Edit")){
                newArticle.edit(newData);
            } else if(command.equals("ChangeAuthor")){
                newArticle.changeAuthor(newData);
            } else if(command.equals("Rename")){
                newArticle.rename(newData);
            }
        }

        System.out.println(newArticle.toString());
    }
}
