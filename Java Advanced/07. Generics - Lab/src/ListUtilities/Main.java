package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(13, 42, 69, 73);

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));

        List<String> list = new ArrayList<>();

        System.out.println(ListUtils.getMax(list));
    }
}
