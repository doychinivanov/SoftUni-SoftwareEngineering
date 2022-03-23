package com.json.processing.entities.products;

import com.json.processing.entities.users.User;

import java.math.BigDecimal;

public class ProductWithNoBuyerDTO {
    private String name;
    private BigDecimal price;
    private String seller;

    public ProductWithNoBuyerDTO(String name, BigDecimal price, String firstName, String lastName) {
        this.name = name;
        this.price = price;

        if (firstName == null) {
            this.seller = lastName;
        } else {
            this.seller = firstName + ' ' + lastName;
        }
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSeller() {
        return seller;
    }
}
