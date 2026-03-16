package app.checkinplay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.checkinplay.dto.SportCreateRequest;
import app.checkinplay.dto.SportResponse;
import app.checkinplay.service.SportService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("sports")
public class SportController {

    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    // TODO: Permissão apenas para admin
    @PostMapping
    public ResponseEntity<SportResponse> saveSport(@Valid @RequestBody SportCreateRequest req) {
        SportResponse sport = sportService.save(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(sport);
    }
}
