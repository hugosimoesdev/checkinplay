package app.checkinplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.checkinplay.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {
    Sport save(String name);
}
