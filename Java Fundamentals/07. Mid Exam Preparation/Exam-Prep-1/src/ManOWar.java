import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pirateShip = Arrays
                .stream(scan.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays
                .stream(scan.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scan.nextLine());
        boolean shipHasSunk = false;
        String input = scan.nextLine();

        while (input.equals("Retire") == false){
            String[] inputData = input.split("\\s+");
            String command = inputData[0];

            executeCommand(command, maxHealth, pirateShip, warShip, inputData);

            boolean piratesStatus = findBrokenSections(pirateShip, "pirates");
            boolean defendersStatus = findBrokenSections(warShip, "defenders");

            if(piratesStatus || defendersStatus){
                shipHasSunk = true;
                break;
            }

            input = scan.nextLine();
        }

        if(!shipHasSunk){
            System.out.printf("Pirate ship status: %d\n", pirateShip.stream().reduce(0, (acc, cur) -> acc+cur));
            System.out.printf("Warship status: %d", warShip.stream().reduce(0, (acc, cur) -> acc+cur));
        }
    }

    public static void executeCommand(String command, int maxHealth, List<Integer> pirates, List<Integer> defenders, String[] data){
        if(command.equals("Fire")){
            int index = Integer.parseInt(data[1]);
            if(checkIndex(index, defenders)){
                int damage = Integer.parseInt(data[2]);
                int healthAfterAttack = defenders.get(index) - damage;
                defenders.set(index, healthAfterAttack);
            }
        } else if(command.equals("Defend")){
            int startIndex = Integer.parseInt(data[1]);
            int endIndex = Integer.parseInt(data[2]);
            int damage = Integer.parseInt(data[3]);

            if(checkIndex(startIndex, pirates) && checkIndex(endIndex, pirates)){
                attackPirates(startIndex, endIndex, damage, pirates);
            }
        } else if(command.equals("Repair")){
            int index = Integer.parseInt(data[1]);
            int hp = Integer.parseInt(data[2]);

            if(checkIndex(index, pirates)){
                int currentHealth = pirates.get(index);
                int newHealth = currentHealth + hp;

                if(newHealth > maxHealth){
                    newHealth = maxHealth;
                }

                pirates.set(index, newHealth);
            }

        } else if(command.equals("Status")){
            double criticalMinimum = maxHealth * 0.2;

            System.out.printf("%d sections need repair.\n", findSectionForRepair(criticalMinimum, pirates));
        }
    }

    public static int findSectionForRepair(double criticalMinimum, List<Integer> pirates){
        int sectionsForRepairing = 0;

        for (int i = 0; i < pirates.size(); i++) {
            if(pirates.get(i) < criticalMinimum){
                sectionsForRepairing++;
            }
        }

        return  sectionsForRepairing;
    }

    public static void attackPirates(int startIndex, int endIndex, int damage, List<Integer> pirates){
        for (int i = startIndex; i <= endIndex; i++) {
            int healthAfterAttack = pirates.get(i) - damage;
            pirates.set(i, healthAfterAttack);
        }
    }

    public static boolean findBrokenSections(List<Integer> ship, String owner){
        boolean isBroken = false;

        for (int i = 0; i < ship.size(); i++) {
            if(ship.get(i) <= 0){
                isBroken = true;
                break;
            }
        }

        if (isBroken){
            if(owner.equals("pirates")){
                System.out.println("You lost! The pirate ship has sunken.");
            } else {
                System.out.println("You won! The enemy ship has sunken.");
            }
        }

        return isBroken;
    }

    public static boolean checkIndex(int index, List<Integer> someList){
        return index >= 0 && index < someList.size();
    }
}
