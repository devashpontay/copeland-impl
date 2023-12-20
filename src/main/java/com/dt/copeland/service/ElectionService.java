package com.dt.copeland.service;

import com.dt.copeland.dto.BallotDTO;
import com.dt.copeland.dto.ElectionDTO;

import java.util.List;

public interface ElectionService {
    ElectionDTO create(ElectionDTO electionDTO);

    ElectionDTO readOne(Long idNo);

    List<ElectionDTO> readAllElectionsByModerator(String moderator);

    List<ElectionDTO> readAllElectionsFromAllUsers();

    List<BallotDTO> readAllVotes(Long idNo);

    String getWinner(Long idNo);

    BallotDTO isDoneVoting(Long idNo, String user);

    ElectionDTO markAsClosed(Long idNo);

    Integer votesCountForElection(Long idNo);


}
