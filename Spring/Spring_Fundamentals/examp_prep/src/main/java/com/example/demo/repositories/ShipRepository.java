package com.example.demo.repositories;

import com.example.demo.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {

}
