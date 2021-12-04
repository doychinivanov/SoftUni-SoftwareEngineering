import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {
    private static String[] seats;
    private static String[] combinations;
    private static List<String> viewers;
    private static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        viewers = Arrays
                .stream(reader.readLine().split(", "))
                .collect(Collectors.toList());

        seats = new String[viewers.size()];

        String command = reader.readLine();

        while (!command.equals("generate")) {
            String[] tokens = command.split(" - ");

            String personName = tokens[0];
            int position = Integer.parseInt(tokens[1]);

            seats[position - 1] = personName;

            viewers.remove(personName);

            command = reader.readLine();
        }

        isUsed = new boolean[viewers.size()];
        combinations = new String[viewers.size()];
        permute(0);
    }

    private static void permute(int index) {
        if (index == combinations.length) {
            printResult();
            return;
        }

        for (int i = 0; i < viewers.size(); i++) {
            if (!isUsed[i]){
                isUsed[i] = true;
                combinations[index] = viewers.get(i);

                permute(index + 1);
                isUsed[i] = false;
            }
        };
    }

    private static void printResult() {
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (String personAtCurrentSeat : seats) {
            if (personAtCurrentSeat != null) {
                result.append(personAtCurrentSeat).append(" ");
            } else {
                result.append(combinations[index++]).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}
