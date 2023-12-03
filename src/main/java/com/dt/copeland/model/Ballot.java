package com.dt.copeland.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = Ballot.ENTITY_NAME)
public class Ballot {
    public static final String ENTITY_NAME = "ballots";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNo;

    @Column(nullable = false)
    private Long electionIdNo;

    @ElementCollection
    private List<Integer> selectedCandidates;

    public Ballot(Long idNo, Long electionIdNo, List<Integer> selectedCandidates) {
        this.idNo = idNo;
        this.electionIdNo = electionIdNo;
        this.selectedCandidates = selectedCandidates;
    }

    public Ballot() {
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

    public List<Integer> getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(List<Integer> selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }
}
