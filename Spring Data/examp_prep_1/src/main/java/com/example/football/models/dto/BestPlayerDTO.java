package com.example.football.models.dto;

import com.example.football.models.entity.PlayerPosition;

public class BestPlayerDTO {
    private String firstName;
    private String lastName;
    private String teamName;
    private String teamStadiumName;
    private PlayerPosition position;

    public PlayerPosition getPosition() {
        return position;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamStadiumName(String stadiumName) {
        this.teamStadiumName = stadiumName;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamStadiumName() {
        return teamStadiumName;
    }

    @Override
    public String toString(){
        return String.format("Player - %s %s%n" +
                        "\tPosition - %s%n" +
                        "\tTeam - %s%n" +
                        "\tStadium - %s",
                this.firstName, this.lastName,
                this.position,
                this.teamName,
                this.teamStadiumName);
    }
}
