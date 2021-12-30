import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSub {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sequence = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lengthOfSeqForEachIndex = new int[sequence.length];
        int[] previousIndexesWithSmallerValue = new int[sequence.length];
        Arrays.fill(previousIndexesWithSmallerValue, -1);

        int totalBestLength = 0, totalBestIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int currElement = sequence[i];

            int currBestLength = 1;
            int currPrevIndex = -1;

            for (int j = i - 1; j >= 0; j--) {

                if (sequence[j] < currElement && lengthOfSeqForEachIndex[j] + 1 >= currBestLength) {
                    currBestLength = lengthOfSeqForEachIndex[j] + 1;
                    currPrevIndex = j;
                }
            }

            previousIndexesWithSmallerValue[i] = currPrevIndex;
            lengthOfSeqForEachIndex[i] = currBestLength;

            if (totalBestLength < currBestLength) {
                totalBestLength = currBestLength;
                totalBestIndex = i;
            }
        }

        List<Integer> LIS = new ArrayList<>();

        int index = totalBestIndex;

        while (index != -1) {
            LIS.add(sequence[index]);
            index = previousIndexesWithSmallerValue[index];
        }


        printResult(LIS);
    }

    private static void printResult(List<Integer> LIS) {
        StringBuilder result = new StringBuilder();
        for (int i = LIS.size() - 1; i >= 0 ; i--) {
            result.append(LIS.get(i)).append(" ");
        }

        System.out.println(result);
    }
}
