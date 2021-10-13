package CountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListCounter<T extends Comparable<T>> {
    private List<T> content;

    public ListCounter(){
        this.content = new ArrayList<>();
    }

    public void add(T element){
        content.add(element);
    }

    public int compare(T toCompareWith){
        Predicate<Integer> isBigger = result -> result > 0;

        return (int) content.stream()
                .mapToInt(x -> x.compareTo(toCompareWith))
                .boxed()
                .filter(isBigger)
                .count();
    }
}
