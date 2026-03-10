package app.checkinplay.mapper;

import java.time.Instant;

import app.checkinplay.dto.UserCreateRequest;
import app.checkinplay.dto.UserResponse;
import app.checkinplay.dto.UserUpdateRequest;
import app.checkinplay.model.User;

public class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserCreateRequest req) {
        return User.builder()
                .name(req.name())
                .email(req.email())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    public static void merge(User entity, UserUpdateRequest req) {
        if (req.name() != null) {
            entity.setName(req.name());
        }

        if (req.email() != null) {
            entity.setEmail(req.email());
        }

        entity.setUpdatedAt(Instant.now());
    }

    public static UserResponse toResponse(User entity) {
        return new UserResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getUpdatedAt());
    }
}
