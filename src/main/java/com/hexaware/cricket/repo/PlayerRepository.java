package com.hexaware.cricket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricket.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
