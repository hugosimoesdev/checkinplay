package app.checkinplay.dto;

import lombok.Builder;

@Builder
public record SportResponse(
                Long id,
                String name) {

}
