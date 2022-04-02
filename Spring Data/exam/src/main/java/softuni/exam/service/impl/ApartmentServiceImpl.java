package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.apartment.ImportApartmentDTO;
import softuni.exam.models.dto.apartment.ImportApartmentRootDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.validation.Validator;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final Path path = Path.of("src", "main", "resources", "files", "xml", "apartments.xml");
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository) throws JAXBException {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();

        JAXBContext ctx = JAXBContext.newInstance(ImportApartmentRootDTO.class);
        this.unmarshaller = ctx.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        ImportApartmentRootDTO apartmentRootDTO = (ImportApartmentRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return apartmentRootDTO
                .getApartments()
                .stream()
                .map(this::importSingleApartment)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importSingleApartment(ImportApartmentDTO apartmentDTO) {
        Set<ConstraintViolation<ImportApartmentDTO>> errors = this.validator.validate(apartmentDTO);

        if(!errors.isEmpty()) return "Invalid apartment";

        Optional<Apartment> existingApartment =  this.apartmentRepository.findByAreaAndTownTownName(apartmentDTO.getArea(), apartmentDTO.getTownName());

        if(existingApartment.isPresent()) return "Invalid apartment";

        Optional<Town> townForApartment = this.townRepository.findByTownName(apartmentDTO.getTownName());

        Apartment newApartment = this.modelMapper.map(apartmentDTO, Apartment.class);
        newApartment.setTown(townForApartment.get());
        this.apartmentRepository.save(newApartment);

        return String.format("Successfully imported apartment %s - %.2f", newApartment.getType().toString(), newApartment.getArea());
    }
}
