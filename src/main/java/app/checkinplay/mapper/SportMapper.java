package app.checkinplay.mapper;

import app.checkinplay.dto.SportCreateRequest;
import app.checkinplay.dto.SportResponse;
import app.checkinplay.model.Sport;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SportMapper {
    public static Sport toEntity(SportCreateRequest req) {
        return Sport.builder()
                .name(req.name())
                .build();
    }

    public static SportResponse toResponse(Sport sport) {
        return SportResponse.builder()
                .id(sport.getId())
                .name(sport.getName())
                .build();
    }
}
