package com.json.processing.entities.users;

import com.json.processing.entities.products.SoldProductDTO;

import java.util.List;

public class UserWithSoldProductsDTO {
    private String firstName;
    private String lastName;
    private List<SoldProductDTO> sellingItems;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSellingItems(List<SoldProductDTO> itemsBought) {
        this.sellingItems = itemsBought;
    }

    public String getLastName() {
        return lastName;
    }

    public List<SoldProductDTO> getSellingItems() {
        return sellingItems;
    }
}
