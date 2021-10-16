package StackIterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack <Integer> implements Iterable<Integer>{
    private ArrayDeque<Integer> stack;

    public Stack(){
        this.stack = new ArrayDeque<>();
    }

    public void push(int element){
        this.stack.push((Integer) java.lang.Integer.valueOf(element));
    }

    public void pop() throws Exception {
        if(!this.stack.isEmpty()) {
            this.stack.pop();
        } else {
            throw new Exception("empty stack");
        }
    }

    public void printStackTwice(){
        List<Integer> result = new ArrayList<>(stack);
        if(!result.isEmpty()){
            for (int i = 0; i < 2; i++) {
                for (Integer number: result) {
                    System.out.println(number);
                }
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = stack.size();
            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public Integer next() {
                return stack.pop();
            }
        };
    }
}
