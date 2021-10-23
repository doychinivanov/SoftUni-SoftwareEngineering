package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(capacity > this.roster.size()){
            this.roster.add(person);
        }
    }

    public boolean remove(String personName){
        Person searchedEmployee = findEmployeeByName(personName);

        if(searchedEmployee != null){
            this.roster.remove(searchedEmployee);
            return true;
        }

        return false;
    }

    public Person getPerson(String name, String hometown){
        Person found = null;

        for (Person person : this.roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                found = person;
                break;
            }
        }

        return found;
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();

        result.append(String.format("The people in the hotel %s are:", this.name)).append(System.lineSeparator());

        this.roster.forEach(person -> result.append(person.toString()).append(System.lineSeparator()));

        return result.toString();
    }

    private Person findEmployeeByName(String name){
        Person found = null;

        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                found = person;
                break;
            }
        }

        return found;
    }
}
