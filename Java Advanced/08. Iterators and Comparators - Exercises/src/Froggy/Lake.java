package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake<Integer> implements Iterable<Integer>{
    private List<Integer> elements;

    public Lake(int[] numbers){
        this.elements = new ArrayList<>();

        for(int n : numbers){
            this.elements.add((Integer) java.lang.Integer.valueOf(n));
        }
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int cursor = elements.size() == 0 ? 0 : -2;

        private boolean isEvenCursor() {
            return cursor % 2 == 0;
        }

        @Override
        public boolean hasNext() {
            if (isEvenCursor() && elements.size() > 2) {
                return true;
            } else if (!isEvenCursor() && elements.size() > 2) {
                return cursor < elements.size() - 2;
            } else {
                return cursor < elements.size() - 1;
            }
        }

        @Override
        public Integer next() {
            cursor += 2;

            if (cursor > elements.size() - 1) {
                cursor = 1;
            }

            return elements.get(cursor);
        }
    }
}
