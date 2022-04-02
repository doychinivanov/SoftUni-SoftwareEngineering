package softuni.exam.models.dto.offer;

import java.math.BigDecimal;

public class BestOfferDTO {
    private String agentFirstName;
    private String agentLastName;
    private long id;
    private double apartmentArea;
    private String apartmentTownTownName;
    private BigDecimal price;

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Agent %s %s with offer №%d:", getAgentFirstName(), getAgentLastName(), getId())).append(System.lineSeparator());
        result.append(String.format("\t-Apartment area: %.2f", getApartmentArea())).append(System.lineSeparator());
        result.append(String.format("\t--Town: %s", getApartmentTownTownName())).append(System.lineSeparator());
        result.append(String.format("\t---Price: %.2f$", getPrice()));


        return result.toString();
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public String getApartmentTownTownName() {
        return apartmentTownTownName;
    }

    public void setApartmentTownTownName(String apartmentTownTownName) {
        this.apartmentTownTownName = apartmentTownTownName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
