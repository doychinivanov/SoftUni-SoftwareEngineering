package StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result = f.getName().length() - s.getName().length();

        if(result == 0){
            char firstLetter = f.getName().toLowerCase(Locale.ROOT).charAt(0);
            char secondLetter = s.getName().toLowerCase(Locale.ROOT).charAt(0);
            result = firstLetter - secondLetter;
        }

        return result;
    }
}
