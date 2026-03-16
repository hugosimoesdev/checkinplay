package app.checkinplay.dto;

import java.util.UUID;

public record SportCreateRequest(
        String name,
        UUID createdBy) {
}
