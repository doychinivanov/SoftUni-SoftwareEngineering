package softuni.exam.models.dto.offer;

import softuni.exam.models.dto.agent.AgentNameDTO;
import softuni.exam.models.dto.apartment.ApartmentIdDTO;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportOfferDTO {

    @XmlElement(name = "price")
    @Positive
    private BigDecimal price;

    @XmlElement(name = "agent")
    private AgentNameDTO agent;

    @XmlElement(name = "apartment")
    private ApartmentIdDTO apartment;

    @XmlElement(name = "publishedOn")
    private String publishedOn;

    public ImportOfferDTO() {}

    public BigDecimal getPrice() {
        return price;
    }

    public AgentNameDTO getAgent() {
        return agent;
    }

    public ApartmentIdDTO getApartment() {
        return apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }
}
