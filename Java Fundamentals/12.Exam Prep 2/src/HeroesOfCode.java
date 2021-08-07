import java.util.*;

public class HeroesOfCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        setUpHeroes(n, heroes, scan);
        heroActions(heroes, scan);

    }

    public static void heroActions(Map<String, List<Integer>> heroes, Scanner scan){
        String input = scan.nextLine();

        while(!input.equals("End")){
            String[] actionData = input.split(" - ");
            String command = actionData[0];
            String heroName = actionData[1];

            List<Integer> heroAbilities = heroes.get(heroName);
            int hp = heroAbilities.get(0);
            int mana = heroAbilities.get(1);

            if(command.equals("CastSpell")){
                onCastSpell(actionData, heroAbilities, mana, heroName);
            } else if(command.equals("TakeDamage")){
                onTakeDamage(heroes, actionData, heroAbilities, hp, heroName);
            } else if(command.equals("Recharge")){
                onRecharge(actionData, heroAbilities, mana, heroName);
            } else if(command.equals("Heal")){
                onHeal(actionData, heroAbilities, hp, heroName);
            }

            input = scan.nextLine();
        }

        heroes
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((a,b) -> b.getValue().get(0) - a.getValue().get(0))
                .forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.printf("  HP: %d\n", hero.getValue().get(0));
                    System.out.printf("  MP: %d\n", hero.getValue().get(1));
                });
    }

    public static void setUpHeroes(int n, Map<String, List<Integer>> heroes, Scanner scan){
        for (int i = 0; i < n; i++) {
            String[] heroData = scan.nextLine().split("\\s+");
            String name = heroData[0];
            int hp = Integer.parseInt(heroData[1]);
            int mana = Integer.parseInt(heroData[2]);

            heroes.putIfAbsent(name, new ArrayList<>());

            List<Integer> heroAbilities = heroes.get(name);
            heroAbilities.add(hp);
            heroAbilities.add(mana);
        }
    }

    public static void onCastSpell(String[] actionData, List<Integer> heroAbilities, int mana, String heroName){
        int requiredMana = Integer.parseInt(actionData[2]);
        String spellName = actionData[3];

        if(mana >= requiredMana){
            heroAbilities.set(1, mana - requiredMana);
            System.out.printf("%s has successfully cast %s and now has %d MP!\n", heroName, spellName, heroAbilities.get(1));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!\n", heroName, spellName);
        }
    }

    public static void onTakeDamage(Map<String, List<Integer>> heroes, String[] actionData, List<Integer> heroAbilities, int hp, String heroName){
        int takenDamage = Integer.parseInt(actionData[2]);
        String attackerName = actionData[3];

        if(hp > takenDamage){
            heroAbilities.set(0, hp - takenDamage);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", heroName, takenDamage, attackerName, heroAbilities.get(0));
        } else {
            heroes.remove(heroName);
            System.out.printf("%s has been killed by %s!\n", heroName, attackerName);
        }
    }

    public static void onRecharge(String[] actionData, List<Integer> heroAbilities, int mana, String heroName){
        int amountToRecharge = Integer.parseInt(actionData[2]);

        if(mana + amountToRecharge > 200){
            amountToRecharge = 200 - mana;
        }

        heroAbilities.set(1, amountToRecharge + mana);
        System.out.printf("%s recharged for %d MP!\n", heroName, amountToRecharge);

    }

    public static void onHeal(String[] actionData, List<Integer> heroAbilities, int hp, String heroName){
        int amountToHeal = Integer.parseInt(actionData[2]);

        if(amountToHeal + hp > 100){
            amountToHeal = 100 - hp;
        }

        heroAbilities.set(0, amountToHeal + hp);
        System.out.printf("%s healed for %d HP!\n", heroName, amountToHeal);
    }
}
