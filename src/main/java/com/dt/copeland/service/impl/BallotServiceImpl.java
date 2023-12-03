package com.dt.copeland.service.impl;

import com.dt.copeland.dto.BallotDTO;
import com.dt.copeland.model.Ballot;
import com.dt.copeland.repository.BallotRepository;
import com.dt.copeland.service.BallotService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BallotServiceImpl implements BallotService {

    private BallotRepository ballotRepository;
    private ModelMapper modelMapper;

    public BallotServiceImpl(BallotRepository ballotRepository, ModelMapper modelMapper) {
        this.ballotRepository = ballotRepository;
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

}
