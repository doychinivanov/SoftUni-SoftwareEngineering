package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList <T extends Comparable<T>> implements Iterable{
    private List<T> elements;

    public CustomList(){
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return this.elements;
    }

    public void add(T item){
        this.elements.add(item);
    }

    public T remove(int index){
        return this.elements.remove(index);
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T firstElement = elements.get(firstIndex);
        T secondElement = elements.get(secondIndex);

        elements.set(firstIndex,secondElement);
        elements.set(secondIndex, firstElement);

    }

    public int countGreaterThan(T itemToCompareWith){
        return (int) this.elements.stream().mapToInt(x -> x.compareTo(itemToCompareWith)).filter(result -> result > 0).count();
    }

    public T getMax(){
        return Collections.max(this.elements);
    }

    public T getMin(){
        return Collections.min(this.elements);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
