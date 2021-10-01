import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> peoplesData = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] currentPerson = scan.nextLine().split(", ");

            String name = currentPerson[0];
            int age = Integer.parseInt(currentPerson[1]);
            peoplesData.put(name, age);
        }

        String ageCondition = scan.nextLine();
        int ageRequirement = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Map.Entry<String, Integer>> ageFilter = getAgeFilter(ageRequirement ,ageCondition);
        Consumer<Map.Entry<String, Integer>> parseOutput = getOutputFormat(format);

        peoplesData
                .entrySet()
                .stream()
                .filter(ageFilter)
                .forEach(parseOutput);
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(int age, String ageCondition){
        if(ageCondition.equals("older")){
            return e -> e.getValue() >= age;
        }
        return e -> e.getValue() <= age;
    }

    private static Consumer<Map.Entry<String, Integer>> getOutputFormat(String format){
        if(format.equals("name age")){
            return e -> System.out.printf("%s - %d" + System.lineSeparator(), e.getKey(), e.getValue());
        } else if(format.equals("name")){
            return e -> System.out.println(e.getKey());
        } else{
            return e -> System.out.println(e.getValue());
        }
    }
}
