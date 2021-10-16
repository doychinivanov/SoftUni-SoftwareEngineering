package StrategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result = f.getAge() - s.getAge();

        if(result > 0){
            return 1;
        } else if(result < 0){
            return -1;
        }

        return 0;
    }
}
