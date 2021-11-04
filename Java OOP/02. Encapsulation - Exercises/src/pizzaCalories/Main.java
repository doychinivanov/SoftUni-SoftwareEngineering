package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean argumentException = false;
        Pizza pizza = null;

        try{
            pizza = createPizza(scan);
            Dough dough = createDough(scan);

            pizza.setDough(dough);
        } catch (IllegalArgumentException e){
            argumentException = true;
            System.out.println(e.getMessage());
        }

        String command = scan.nextLine();

        while (!command.equals("END") && !argumentException){
            String[] toppingData = command.split("\\s+");
            String toppingType = toppingData[1];
            int toppingWeight = Integer.parseInt(toppingData[2]);

            try{
                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                argumentException = true;
                break;
            }


            command = scan.nextLine();
        }

        if(pizza != null && !argumentException) System.out.println(pizza);
    }

    private static Dough createDough(Scanner scan) {
        String[] doughData = scan.nextLine().split("\\s+");
        String doughType = doughData[1];
        String bakingTechnique = doughData[2];
        int weight = Integer.parseInt(doughData[3]);

        return new Dough(doughType, bakingTechnique, weight);
    }

    private static Pizza createPizza(Scanner scan) {
        String[] pizzaData = scan.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int toppingsCount = Integer.parseInt(pizzaData[2]);

        return new Pizza(pizzaName, toppingsCount);
    }
}
