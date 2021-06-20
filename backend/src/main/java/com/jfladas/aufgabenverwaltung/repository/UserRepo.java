package com.example.aufgabenverwaltung.repository;

import com.example.aufgabenverwaltung.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String name, String password);

    @Query(value = "SELECT * FROM user WHERE name = ?1", nativeQuery = true)
    User getByName(String name);

    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User getById(long id);

    @Query(value = "SELECT id FROM user WHERE name = ?1", nativeQuery = true)
    long getIdByName(String name);
}