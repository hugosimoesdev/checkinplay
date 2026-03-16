package app.checkinplay.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import app.checkinplay.dto.SportCreateRequest;
import app.checkinplay.dto.SportResponse;
import app.checkinplay.exception.ResourceNotFoundException;
import app.checkinplay.mapper.SportMapper;
import app.checkinplay.model.Sport;
import app.checkinplay.model.User;
import app.checkinplay.repository.SportRepository;
import app.checkinplay.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class SportService {

    private final SportRepository repository;
    private final UserRepository userRepository;

    public SportService(SportRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Transactional
    public SportResponse save(@Valid SportCreateRequest req) {
        Sport sport = SportMapper.toEntity(req);

        UUID userId = req.createdBy();
        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User", userId));
            sport.setCreatedBy(user);
        }

        Sport savedSport = repository.save(sport);
        return SportMapper.toResponse(savedSport);
    }
}
