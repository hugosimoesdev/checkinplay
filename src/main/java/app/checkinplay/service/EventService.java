package app.checkinplay.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import app.checkinplay.dto.EventCreateRequest;
import app.checkinplay.dto.EventResponse;
import app.checkinplay.exception.SportNotFoundException;
import app.checkinplay.exception.UserNotFoundException;
import app.checkinplay.mapper.EventMapper;
import app.checkinplay.model.Event;
import app.checkinplay.model.Sport;
import app.checkinplay.model.User;
import app.checkinplay.repository.EventRepository;
import app.checkinplay.repository.SportRepository;
import app.checkinplay.repository.UserRepository;

@Service
public class EventService {

    EventRepository repository;
    UserRepository userRepository;
    SportRepository sportRepository;

    public EventService(EventRepository repository, UserRepository userRepository, SportRepository sportRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.sportRepository = sportRepository;
    }

    public EventResponse create(EventCreateRequest req) {
        Event event = EventMapper.toEntity(req);

        Long sportId = req.sportId();

        if (sportId != null) {
            Sport sport = sportRepository.findById(sportId)
                    .orElseThrow(() -> new SportNotFoundException(sportId));
            event.setSportId(sport);
        }

        UUID userId = req.createdBy();

        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException(userId));
            event.setCreatedBy(user);
        }

        return EventMapper.toResponse(repository.save(event));
    }

    public EventResponse getById(Long id) {
        return EventMapper.toResponse(repository.findById(id).orElseThrow(() -> new SportNotFoundException(id)));
    }

    public List<EventResponse> getAll() {
        return repository.findAll().stream().map(EventMapper::toResponse).toList();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
