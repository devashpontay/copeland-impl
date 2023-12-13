package com.dt.copeland.controller;

import com.dt.copeland.dto.BallotDTO;
import com.dt.copeland.service.BallotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(BallotController.PATH)
public class BallotController {
    public static final String PATH = "/api/v1/ballots";

    private BallotService ballotService;

    public BallotController(BallotService ballotService) {
        this.ballotService = ballotService;
    }

    @PostMapping
    public ResponseEntity<BallotDTO> post(@RequestBody BallotDTO ballotDTO) {
        BallotDTO savedBallotDTO = ballotService.create(ballotDTO);
        return new ResponseEntity<>(savedBallotDTO, HttpStatus.CREATED);
    }
}
