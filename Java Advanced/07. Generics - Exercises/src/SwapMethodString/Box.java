package SwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box <T> {
    private List<T> content;

    public Box(){
        this.content = new ArrayList<>();
    }

    public void addElements(T element){
        content.add(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T firstElement = content.get(firstIndex);
        T secondElement = content.get(secondIndex);

        content.set(firstIndex, secondElement);
        content.set(secondIndex, firstElement);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        content
                .forEach(element -> result.append(element.getClass().getName()).append(": ").append(element).append(System.lineSeparator()));

        return result.toString();
    }
}
