package com.dt.copeland.controller;

import com.dt.copeland.dto.BallotDTO;
import com.dt.copeland.dto.ElectionDTO;
import com.dt.copeland.service.ElectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(ElectionController.PATH)
public class ElectionController {
    public static final String PATH = "/api/v1/elections";

    private ElectionService electionService;

    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }


    @GetMapping("/query")
    public ResponseEntity<List<ElectionDTO>> getAllElectionsByModerator(@RequestParam String moderator) {
        return ResponseEntity.ok(electionService.readAllElectionsByModerator(moderator));
    }

    @GetMapping()
    public ResponseEntity<List<ElectionDTO>> getAllElectionsFromAllUser() {
        return ResponseEntity.ok(electionService.readAllElectionsFromAllUsers());
    }

    @PostMapping
    public ResponseEntity<ElectionDTO> post(@RequestBody ElectionDTO electionDTO) {
        ElectionDTO savedElectionDTO = electionService.create(electionDTO);
        return new ResponseEntity<>(savedElectionDTO, HttpStatus.CREATED);
    }

    @GetMapping("{idNo}")
    public ResponseEntity<ElectionDTO> getOne(@PathVariable Long idNo) {
        ElectionDTO electionDTO = electionService.readOne(idNo);
        return ResponseEntity.ok(electionDTO);
    }

    @GetMapping("/{idNo}/votes")
    public ResponseEntity<List<BallotDTO>> getAllVotes(@PathVariable Long idNo) {
        return ResponseEntity.ok(electionService.readAllVotes(idNo));
    }

    @GetMapping("/{idNo}/winner")
    public ResponseEntity<String> getWinner(@PathVariable Long idNo) {
        return ResponseEntity.ok(electionService.getWinner(idNo));
    }

    @GetMapping("/{idNo}/votes/{user}")
    public ResponseEntity<BallotDTO> isDoneVoting(@PathVariable Long idNo, @PathVariable String user) {
        return ResponseEntity.ok(electionService.isDoneVoting(idNo, user));
    }

    @PatchMapping("/{idNo}/close")
    public ResponseEntity<ElectionDTO> markAsClosed(@PathVariable Long idNo){
        return ResponseEntity.ok(electionService.markAsClosed(idNo));
    }

    @GetMapping("/{idNo}/votes/count")
    public ResponseEntity<Integer> getVotersCountForElection(@PathVariable Long idNo) {
        return ResponseEntity.ok(electionService.votesCountForElection(idNo));
    }

    @DeleteMapping("/{idNo}")
    public ResponseEntity<String> deleteElection(@PathVariable Long idNo) {
        electionService.delete(idNo);
        return ResponseEntity.ok("DELETED");
    }


}
