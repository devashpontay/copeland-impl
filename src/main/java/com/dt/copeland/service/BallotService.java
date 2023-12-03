package com.dt.copeland.service;

import com.dt.copeland.dto.BallotDTO;
import com.dt.copeland.model.Ballot;

import java.util.List;

public interface BallotService {
    BallotDTO create(BallotDTO ballotDTO);

    List<Ballot> readAllVotesForElection(Long idNo);
}
