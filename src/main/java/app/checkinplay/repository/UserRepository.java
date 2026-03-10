package app.checkinplay.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import app.checkinplay.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(UUID id);

    boolean existsByEmail(String email);
}
