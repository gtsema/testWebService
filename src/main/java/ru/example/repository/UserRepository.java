package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
