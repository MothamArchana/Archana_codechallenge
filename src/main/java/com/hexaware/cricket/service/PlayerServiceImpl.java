package com.hexaware.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.repo.PlayerRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	PlayerRepository repository;

	public Player addPlayer(PlayerDTO dto) {

		Player player = new Player();
		player.setPlayerName(dto.getPlayerName());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setRole(dto.getRole());
		player.setTotalMatches(dto.getTotalMatches());
		player.setTeamName(dto.getTeamName());
		player.setCountryName(dto.getCountryName());
		player.setDescription(dto.getDescription());
		return repository.save(player);
	}

	public Player updatePlayer(int playerId, PlayerDTO dto) {

		Player player = repository.findById(playerId)
				.orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
		player.setPlayerName(dto.getPlayerName());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setRole(dto.getRole());
		player.setTotalMatches(dto.getTotalMatches());
		player.setTeamName(dto.getTeamName());
		player.setCountryName(dto.getCountryName());
		player.setDescription(dto.getDescription());
		return repository.save(player);
	}

	public Player getPlayerById(int playerId) {

		return repository.findById(playerId)
				.orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
	}

	public List<Player> getAllPlayers() {

		return repository.findAll();
	}

	public String deletePlayer(int playerId) {

		Player player = repository.findById(playerId)
				.orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
		repository.delete(player);
		return "Player deleted with id " + playerId;
	}

}
