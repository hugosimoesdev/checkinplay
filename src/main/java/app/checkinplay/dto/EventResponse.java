package app.checkinplay.dto;

import lombok.Builder;

@Builder
public record EventResponse(
        Long id,
        String title,
        String description,
        UserResponse createdBy,
        SportResponse sport) {

}
