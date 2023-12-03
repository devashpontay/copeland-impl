package com.dt.copeland.dto;

import java.util.List;

public class BallotDTO {

    private Long idNo;
    private Long electionIdNo;
    private List<String> selectedCandidates;

    public BallotDTO(Long idNo, Long electionIdNo, List<String> selectedCandidates) {
        this.idNo = idNo;
        this.electionIdNo = electionIdNo;
        this.selectedCandidates = selectedCandidates;
    }

    public BallotDTO() {
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public Long getElectionIdNo() {
        return electionIdNo;
    }

    public void setElectionIdNo(Long electionIdNo) {
        this.electionIdNo = electionIdNo;
    }

    public List<String> getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(List<String> selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }
}
