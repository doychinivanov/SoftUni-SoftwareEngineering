package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Library<Book> implements Iterable<Book>{
    private List<Book> collection;

    @SafeVarargs
    public Library(Book... books){
        setCollection(books);
    }

    @SafeVarargs
    public final void setCollection(Book... books) {
        this.collection = new ArrayList<Book>();

        if(books.length > 0){
            this.collection.addAll(Arrays.asList(books));
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < collection.size();
            }

            @Override
            public Book next() {
                return collection.get(counter++);
            }
        };
    }
}

