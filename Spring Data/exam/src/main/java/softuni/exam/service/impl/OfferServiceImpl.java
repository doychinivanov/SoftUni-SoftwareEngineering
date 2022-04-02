package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.offer.BestOfferDTO;
import softuni.exam.models.dto.offer.ImportOfferDTO;
import softuni.exam.models.dto.offer.ImportOfferRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final Path path = Path.of("src", "main", "resources", "files", "xml", "offers.xml");
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final Unmarshaller unmarshaller;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository) throws JAXBException {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(ctx -> LocalDate.parse(ctx.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                String.class, LocalDate.class);

        JAXBContext ctx = JAXBContext.newInstance(ImportOfferRootDTO.class);
        this.unmarshaller = ctx.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        ImportOfferRootDTO offerRootDTO = (ImportOfferRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return offerRootDTO
                .getOffers()
                .stream()
                .map(this::importSingleOffer)
                .collect(Collectors.joining(System.lineSeparator()));
    }


    @Override
    public String exportOffers() {
        List<Offer> bestOffers = this.offerRepository.findBestOffers();

//        return bestOffers.stream().map(of -> of.getAgent().getFirstName()).collect(Collectors.joining(System.lineSeparator()));
        List<BestOfferDTO> bestOfferDTOS = bestOffers
                .stream()
                .map(offer -> this.modelMapper.map(offer, BestOfferDTO.class))
                .toList();

        return bestOfferDTOS
                .stream()
                .map(BestOfferDTO::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importSingleOffer(ImportOfferDTO offerDTO) {
        Set<ConstraintViolation<ImportOfferDTO>> errors = this.validator.validate(offerDTO);

        if(!errors.isEmpty()) return "Invalid offer";

        Optional<Apartment> apartmentForOffer = this.apartmentRepository.findById(offerDTO.getApartment().getId());
        Optional<Agent> existingAgent = this.agentRepository.findByFirstName(offerDTO.getAgent().getName());

        if(existingAgent.isEmpty()) return "Invalid offer";

        Offer newOffer = this.modelMapper.map(offerDTO, Offer.class);
        newOffer.setApartment(apartmentForOffer.get());
        newOffer.setAgent(existingAgent.get());

        this.offerRepository.save(newOffer);

        return String.format("Successfully imported offer %.2f", newOffer.getPrice());
    }

}
