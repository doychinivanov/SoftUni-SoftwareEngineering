package softuni.exam.models.dto.town;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ImportTownDTO {
    @Size(min = 2)
    private String townName;

    @Min(1)
    private int population;

    public ImportTownDTO() {}

    public String getTownName() {
        return townName;
    }

    public int getPopulation() {
        return population;
    }
}
