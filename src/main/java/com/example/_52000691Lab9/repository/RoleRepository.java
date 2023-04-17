package com.example._52000691Lab9.repository;

import com.example._52000691Lab9.model.Role;
import com.example._52000691Lab9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
