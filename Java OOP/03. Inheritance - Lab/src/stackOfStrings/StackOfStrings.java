package stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;
    private int index;

    public StackOfStrings(){
        this.data = new ArrayList<>();
        this.index = -1;
    }

    public void push(String item){
        this.index++;
        this.data.add(item);
    }

    public String pop () {
        return this.data.remove(index--);
    }

    public String peek () {
        return this.data.get(index);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
