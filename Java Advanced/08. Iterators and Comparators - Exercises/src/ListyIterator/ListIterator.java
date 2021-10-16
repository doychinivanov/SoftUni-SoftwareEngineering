package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator<String> implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListIterator(String... params){
        this.index = 0;
        this.data = new ArrayList<>();
        this.data.addAll(Arrays.asList(params));
    }

    public boolean move(){
        if(index + 1 < this.data.size()){
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        return this.index + 1 < this.data.size();
    }

    public void print() throws Exception {
        if(this.index > this.data.size() - 1){
            throw new Exception("Index out of boundary");
        }

        System.out.println(this.data.get(index));
    }

    public void printAll(){
        StringBuilder result = new StringBuilder();
        this.data.forEach(x -> result.append(x).append(" "));

        System.out.println(result);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < data.size();
            }

            @Override
            public String next() {
                return data.get(i);
            }
        };
    }
}
