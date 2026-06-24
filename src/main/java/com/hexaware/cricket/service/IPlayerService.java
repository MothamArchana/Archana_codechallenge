package com.hexaware.cricket.service;

import java.util.List;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;

public interface IPlayerService {

	Player addPlayer(PlayerDTO dto);

	Player updatePlayer(int playerId, PlayerDTO dto);

	Player getPlayerById(int playerId);

	List<Player> getAllPlayers();

	String deletePlayer(int playerId);

	Player getPlayerByJerseyNumber(int jerseyNumber);
}
