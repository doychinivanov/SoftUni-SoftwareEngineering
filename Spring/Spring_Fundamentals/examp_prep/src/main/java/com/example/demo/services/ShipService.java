package com.example.demo.services;

import com.example.demo.models.dto.CatalogShipDTO;
import com.example.demo.models.dto.CreateShipDTO;
import com.example.demo.models.dto.ShipNameDTO;

import java.util.List;

public interface ShipService {

    boolean createShip(CreateShipDTO createShipDTO);

    List<CatalogShipDTO> getAllShipsCatalog();

    List<ShipNameDTO> getShipForCurrentUser();

    List<ShipNameDTO> getEnemyShips();

}
