package com.dt.copeland.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = Election.ENTITY_NAME)
public class Election {
    public static final String ENTITY_NAME = "elections";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNo;
    private String moderator;
    private String title;
    private String category;
    private String status;
    private int candidateCount;
    @ElementCollection
    private List<String> candidates;

    public Election(Long idNo, String title, String category, String status, int candidateCount, List<String> candidates) {
        this.idNo = idNo;
        this.title = title;
        this.category = category;
        this.status = status;
        this.candidateCount = candidateCount;
        this.candidates = candidates;
    }

    public Election() {
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCandidateCount() {
        return candidateCount;
    }

    public void setCandidateCount(int candidateCount) {
        this.candidateCount = candidateCount;
    }

    public List<String> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<String> candidates) {
        this.candidates = candidates;
    }
}
