package com.example.demo.models.dto;

public class CatalogShipDTO {

    private String name;

    private long health;

    private long power;

    public CatalogShipDTO () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }
}
