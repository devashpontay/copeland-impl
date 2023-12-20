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
    private String voterUserName;

    @ManyToOne
    @JoinColumn(name = "election_id_no", nullable = false)
    private Election election;

    @ElementCollection
    private List<Integer> selectedCandidates;

    public Ballot() {
    }

    public Ballot(Long idNo, String voterUserName, Election election, List<Integer> selectedCandidates) {
        this.idNo = idNo;
        this.voterUserName = voterUserName;
        this.election = election;
        this.selectedCandidates = selectedCandidates;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getVoterUserName() {
        return voterUserName;
    }

    public void setVoterUserName(String voterUserName) {
        this.voterUserName = voterUserName;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public List<Integer> getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(List<Integer> selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }
}
