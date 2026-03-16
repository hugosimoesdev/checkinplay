package app.checkinplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.checkinplay.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
