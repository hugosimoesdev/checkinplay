package app.checkinplay.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.checkinplay.dto.EventCreateRequest;
import app.checkinplay.dto.EventResponse;
import app.checkinplay.service.EventService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {
    EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody EventCreateRequest event) {
        var eventSaved = service.create(event);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventSaved);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        var events = service.getAll();

        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        var event = service.getById(id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
