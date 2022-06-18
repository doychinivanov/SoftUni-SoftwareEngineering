package com.example.demo.repositories;

import com.example.demo.models.Ship;
import com.example.demo.models.dto.ShipNameDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

    List<Ship> findAll();

    List<Ship> findAllByUserId(long userId);

    List<Ship> getNamesByUserId(long userId);

    List<Ship> findByUserIdNot(long userId);
}
