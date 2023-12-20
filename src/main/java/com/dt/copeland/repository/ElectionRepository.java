package com.dt.copeland.repository;

import com.dt.copeland.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    List<Election> findAllByModerator(String moderator);

}
