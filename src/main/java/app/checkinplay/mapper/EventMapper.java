package app.checkinplay.mapper;

import app.checkinplay.dto.EventCreateRequest;
import app.checkinplay.dto.EventResponse;
import app.checkinplay.model.Event;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventMapper {
    public static Event toEntity(EventCreateRequest req) {
        return Event.builder()
                .title(req.title())
                .description(req.description())
                .build();
    }

    public static EventResponse toResponse(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .createdBy(UserMapper.toResponse(event.getCreatedBy()))
                .sport(SportMapper.toResponse(event.getSportId()))
                .build();
    }
}
