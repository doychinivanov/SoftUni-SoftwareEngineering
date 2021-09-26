import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> phoneBook = new HashMap<>();
        String input = scan.nextLine();

        populatePhoneBook(scan, phoneBook, input);

        input = scan.nextLine();

        checkIfPersonIsInPhoneBook(scan, phoneBook, input);
    }

    private static void checkIfPersonIsInPhoneBook(Scanner scan, HashMap<String, String> phoneBook, String input) {
        while (!input.equals("stop")){
            String nameToFind = input;

            if(phoneBook.containsKey(nameToFind)){
                System.out.printf("%s -> %s" + System.lineSeparator(), nameToFind, phoneBook.get(nameToFind));
            } else {
                System.out.printf("Contact %s does not exist." + System.lineSeparator(), nameToFind);
            }

            input = scan.nextLine();
        }
    }

    private static void populatePhoneBook(Scanner scan, HashMap<String, String> phoneBook, String input) {
        while(!input.equals("search")){
            String[] data = input.split("-");

            String personName = data[0];
            String personNumber = data[1];

            phoneBook.put(personName, personNumber);

            input = scan.nextLine();
        }
    }
}
