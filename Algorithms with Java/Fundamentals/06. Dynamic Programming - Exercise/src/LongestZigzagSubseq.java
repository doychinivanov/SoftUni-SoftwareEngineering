import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LongestZigzagSubseq {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sequence = Arrays.stream(reader
                .readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[sequence.length + 1][2];
        int[][] prev = new int[sequence.length + 1][2];

//        Greater
        dp[0][0] = 1;
//        Less
        dp[0][1] = 1;

        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;

        int[] best = new int[2];

        for (int currentIndex = 0; currentIndex < sequence.length; currentIndex++) {
            int currentNumber = sequence[currentIndex];

            for (int prevIndex = currentIndex - 1; prevIndex >= 0 ; prevIndex--) {
                int prevNumber = sequence[prevIndex];

                if (currentNumber > prevNumber && dp[currentIndex][0] <= dp[prevIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                } else if (currentNumber < prevNumber && dp[currentIndex][1] <= dp[prevIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }

            if (maxLength < dp[currentIndex][0]) {
                maxLength = dp[currentIndex][0];
                best[0] = currentIndex;
                best[1] = 0;
            } else if (maxLength < dp[currentIndex][1]) {
                maxLength = dp[currentIndex][1];
                best[0] = currentIndex;
                best[1] = 1;
            }
        }

        Deque<Integer> zigzagSequence = new ArrayDeque<>();

        int beginRow = best[0];

        while (beginRow >= 0) {
            zigzagSequence.push(sequence[beginRow]);
            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }

        StringBuilder result = new StringBuilder();
        while (!zigzagSequence.isEmpty()) {
            result.append(zigzagSequence.pop()).append(" ");
        }

        System.out.println(result);
    }
}
