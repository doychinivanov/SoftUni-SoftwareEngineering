import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> listProto= Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        List<String> mergedList = new ArrayList<>();

        for (int i = listProto.size() - 1; i >= 0 ; i--) {
            List<String> currentList = Arrays.stream(listProto.get(i).split("\\s+")).filter(x -> x.equals("")==false).collect(Collectors.toList());

            mergedList.addAll(currentList);
        }

        System.out.println(String.join(" ", mergedList));
    }
}