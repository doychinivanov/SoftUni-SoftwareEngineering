package CustomList;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        int size = list.getElements().size();
        for (int i = 0; i < size; i++) {
            T element = list.getElements().get(i);
            for (int j = i + 1; j < size; j++) {
                T nextElement = list.getElements().get(j);

                if(element.compareTo(nextElement) > 0){
                    list.swap(i, j);
                }
            }
        }
    }
}
