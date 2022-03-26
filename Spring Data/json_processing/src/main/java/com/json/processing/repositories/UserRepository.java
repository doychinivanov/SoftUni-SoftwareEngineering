package com.json.processing.repositories;

import com.json.processing.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u" +
            " JOIN u.sellingItems p" +
            " WHERE p.buyer IS NOT NULL" +
            " ORDER BY u.lastName, u.firstName")
    List<User> findAllWithSoldProducts();
}
