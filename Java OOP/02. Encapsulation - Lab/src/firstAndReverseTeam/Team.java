package firstAndReverseTeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Team {
    private final String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name){
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Person player){
        if(player.getAge() < 40){
            firstTeam.add(player);
        } else {
            reserveTeam.add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }
}
