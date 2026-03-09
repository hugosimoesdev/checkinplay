package app.checkinplay.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import app.checkinplay.dto.UserCreateRequest;
import app.checkinplay.dto.UserResponse;
import app.checkinplay.dto.UserUpdateRequest;
import app.checkinplay.exception.ResourceNotFoundException;
import app.checkinplay.mapper.UserMapper;
import app.checkinplay.model.User;
import app.checkinplay.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse create(@Valid UserCreateRequest req) {
        User entity = UserMapper.toEntity(req);
        entity = repository.save(entity);

        return UserMapper.toResponse(entity);
    }

    @Transactional
    public UserResponse update(UUID id, @Valid UserUpdateRequest req){
        User entity = getById(id);

        UserMapper.merge(entity, req);
        entity = repository.save(entity);

        return UserMapper.toResponse(entity);
    }

    @Transactional
    public void delete(UUID id) {
        User entity = getById(id);
        repository.delete(entity);
    }

    public List<UserResponse> getAll() {
        return repository.findAll().stream().map(UserMapper::toResponse).toList();
    }

    public User getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
    }
}