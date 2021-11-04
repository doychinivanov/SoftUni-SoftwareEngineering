package shoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        HashMap<String, Product> products = new HashMap<>();

        String[] peopleData = scan.nextLine().split(";");
        String[] productData = scan.nextLine().split(";");

        boolean initializationException = false;

        try{
            populatePeople(people, peopleData);
            populateProducts(products, productData);
        } catch (Exception e){
            initializationException = true;
            System.out.println(e.getMessage());
        }


        String command = scan.nextLine();

        while (!command.equals("END") && !initializationException){

            String[] commandData = command.split("\\s+");

            String personName = commandData[0];
            String productName = commandData[1];

            try{
                Person currentPerson = people.get(personName);
                Product goalProduct = products.get(productName);
                currentPerson.buyProduct(goalProduct);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            command = scan.nextLine();
        }

        people.forEach((key, value) -> System.out.println(value));
    }

    private static void populateProducts(HashMap<String, Product> products, String[] productData) {
        for (String productInfo: productData) {
            String[] info = productInfo.split("=");
            String productName = info[0];
            double productCost = Double.parseDouble(info[1]);

            products.put(productName, new Product(productName, productCost));
        }
    }

    private static void populatePeople(LinkedHashMap<String, Person> people, String[] peopleData) {
        for (String personData: peopleData) {
            String[] info = personData.split("=");
            String personName = info[0];
            double personMoney = Double.parseDouble(info[1]);

            people.put(personName, new Person(personName, personMoney));
        }
    }
}
