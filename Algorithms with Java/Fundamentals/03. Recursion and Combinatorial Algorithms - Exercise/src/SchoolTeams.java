import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SchoolTeams {
    private static final int allowedGirls = 3;
    private static final int allowedBoys = 2;

    private static String[] girls;
    private static String[] boys;
    private static String[] currentGirlsCombination;
    private static String[] currentBoysCombination;

    private static final List<String> allGirlsCombinations = new ArrayList<>();
    private static final List<String> allBoysCombinations = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        girls = reader.readLine().split(", ");
        boys = reader.readLine().split(", ");

        currentGirlsCombination = new String[allowedGirls];
        currentBoysCombination = new String[allowedBoys];

        combineGirls(0, 0);
        combineBoys(0, 0);
        
        printResult();
    }

    private static void printResult() {
        StringBuilder result = new StringBuilder();

        allGirlsCombinations.forEach(girlsCombo -> {
            allBoysCombinations.forEach(boysCombo -> {
                result.append(girlsCombo).append(", ").append(boysCombo).append(System.lineSeparator());
            });
        });

        System.out.print(result);
    }

    private static void combineGirls(int index, int start) {
        if (index == allowedGirls) {
            allGirlsCombinations.add(String.join(", ", currentGirlsCombination));
            return;
        }

        for (int i = start; i < girls.length; i++) {
            currentGirlsCombination[index] = girls[i];
            combineGirls(index + 1, i + 1);
        }
    }

    private static void combineBoys(int index, int start) {
        if (index == allowedBoys) {
            allBoysCombinations.add(String.join(", ", currentBoysCombination));
            return;
        }

        for (int i = start; i < boys.length; i++) {
            currentBoysCombination[index] = boys[i];
            combineBoys(index + 1, i + 1);
        }
    }
}
