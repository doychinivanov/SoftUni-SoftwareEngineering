package Jar;

import java.util.ArrayDeque;

public class Jar <T>{
    private ArrayDeque<T> jar;

    public Jar(){
        this.jar = new ArrayDeque<>();
    }

    public void add(T newElement){
        this.jar.push(newElement);
    }

    public T remove(){
        return this.jar.pop();
    }

    public ArrayDeque<T> getJar() {
        return this.jar;
    }

    public int getJarSize(){
        return this.jar.size();
    }
}
