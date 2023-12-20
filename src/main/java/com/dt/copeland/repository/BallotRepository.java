package com.dt.copeland.repository;

import com.dt.copeland.model.Ballot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BallotRepository extends JpaRepository<Ballot, Long> {
    List<Ballot> findAllByElectionIdNo(Long idNo);

    Ballot findBallotByElectionIdNoAndVoterUserName(Long idNo, String user);
}
