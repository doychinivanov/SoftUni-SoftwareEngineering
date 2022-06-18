package com.example.demo.services.impl;

import com.example.demo.models.Category;
import com.example.demo.models.Ship;
import com.example.demo.models.User;
import com.example.demo.models.dto.CatalogShipDTO;
import com.example.demo.models.dto.CreateShipDTO;
import com.example.demo.models.dto.ShipNameDTO;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ShipRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ShipService;
import com.example.demo.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private ShipRepository shipRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private UserSession loggedUser;

    private CategoryRepository categoryRepository;

    @Autowired
    public ShipServiceImpl(
            ShipRepository shipRepository,
            UserRepository userRepository,
            ModelMapper modelMapper,
            UserSession loggedUser, CategoryRepository categoryRepository) {
        this.shipRepository = shipRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean createShip(CreateShipDTO createShipDTO) {
        Optional<Ship> possibleShip = this.shipRepository.findByName(createShipDTO.getName());

        if (possibleShip.isPresent()) {
            return false;
        }

        User currentUser = this.userRepository.findById(loggedUser.getId()).get();
        Category category = this.categoryRepository.findById(createShipDTO.getCategory());
        Ship newShip = this.modelMapper.map(createShipDTO, Ship.class);
        newShip.setUser(currentUser);
        newShip.setCategory(category);

        this.shipRepository.save(newShip);
        return true;
    }

    @Override
    public List<CatalogShipDTO> getAllShipsCatalog() {
        List<Ship> allShips = this.shipRepository.findAll();


        return allShips.stream()
                .map(entity -> modelMapper.map(entity, CatalogShipDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipNameDTO> getShipForCurrentUser() {
//        List<Ship> userShips = this.shipRepository.findAllByUserId(loggedUser.getId());

        List<Ship> userShipsNames = this.shipRepository.getNamesByUserId(loggedUser.getId());

        return userShipsNames.stream()
                .map(entity -> modelMapper.map(entity, ShipNameDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipNameDTO> getEnemyShips() {
        List<Ship> enemyShipNames = this.shipRepository.findByUserIdNot(loggedUser.getId());

        return enemyShipNames.stream()
                .map(entity -> modelMapper.map(entity, ShipNameDTO.class))
                .collect(Collectors.toList());
    }
}
