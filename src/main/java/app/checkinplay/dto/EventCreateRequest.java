package app.checkinplay.dto;

import java.util.UUID;

public record EventCreateRequest(
        String title,
        String description,
        UUID createdBy,
        Long sportId) {

}
