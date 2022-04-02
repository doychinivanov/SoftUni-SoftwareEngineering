package softuni.exam.models.dto.agent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AgentNameDTO {

    @XmlElement
    private String name;

    public String getName() {
        return name;
    }
}
