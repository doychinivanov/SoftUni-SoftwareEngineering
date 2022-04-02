package softuni.exam.models.dto.apartment;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportApartmentDTO {

    @XmlElement(name = "apartmentType")
    private String apartmentType;

    @XmlElement(name = "area")
    @Min(40)
    private double area;

    @XmlElement(name = "town")
    private String townName;

    public ImportApartmentDTO() {}

    public String getApartmentType() {
        return apartmentType;
    }

    public double getArea() {
        return area;
    }

    public String getTownName() {
        return townName;
    }
}
