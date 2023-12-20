package com.dt.copeland.service.impl;

import com.dt.copeland.dto.BallotDTO;
import com.dt.copeland.exception.ResourceNotFoundException;
import com.dt.copeland.model.Ballot;
import com.dt.copeland.model.Election;
import com.dt.copeland.repository.BallotRepository;
import com.dt.copeland.repository.ElectionRepository;
import com.dt.copeland.service.BallotService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BallotServiceImpl implements BallotService {

    private BallotRepository ballotRepository;
    private ElectionRepository electionRepository;
    private ModelMapper modelMapper;

    public BallotServiceImpl(BallotRepository ballotRepository, ElectionRepository electionRepository, ModelMapper modelMapper) {
        this.ballotRepository = ballotRepository;
        this.electionRepository = electionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BallotDTO create(BallotDTO ballotDTO) {
        Ballot ballotObj = modelMapper.map(ballotDTO, Ballot.class);
        Ballot savedBallotObj = ballotRepository.save(ballotObj);
        return modelMapper.map(savedBallotObj, BallotDTO.class);
    }

    @Override
    public List<Ballot> readAllVotesForElection(Long idNo) {
        return ballotRepository.findAllByElectionIdNo(idNo);
    }

    @Override
    public BallotDTO readUserVoteForElection(Long idNo, String user) {

        Election electionSession = electionRepository
                .findById(idNo)
                .orElseThrow(() -> new ResourceNotFoundException("Election not found with the given ID!"));

        Ballot ballot = ballotRepository.findBallotByElectionIdNoAndVoterUserName(idNo, user);
        System.out.println(ballot);
        return modelMapper.map(ballot, BallotDTO.class);
    }

}
