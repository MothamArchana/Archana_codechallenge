package com.hexaware.cricket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.repo.PlayerRepository;
import com.hexaware.cricket.service.PlayerServiceImpl;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {

	@Mock
	PlayerRepository repository;

	@InjectMocks
	PlayerServiceImpl service;

	@Test
	void addPlayer_savesAndReturns() {

		PlayerDTO dto = new PlayerDTO();
		dto.setPlayerName("Virat Kohli");
		dto.setJerseyNumber(18);
		dto.setRole("Batsman");
		dto.setTeamName("India");
		dto.setCountryName("India");

		Player saved = new Player();
		saved.setPlayerId(1);
		saved.setPlayerName("Virat Kohli");
		when(repository.save(any(Player.class))).thenReturn(saved);

		Player result = service.addPlayer(dto);

		assertEquals("Virat Kohli", result.getPlayerName());
		verify(repository, times(1)).save(any(Player.class));
	}

	@Test
	void getPlayerById_found_returnsPlayer() {

		Player player = new Player();
		player.setPlayerId(1);
		player.setPlayerName("Rohit Sharma");
		when(repository.findById(1)).thenReturn(Optional.of(player));

		Player result = service.getPlayerById(1);

		assertEquals("Rohit Sharma", result.getPlayerName());
	}

	@Test
	void getPlayerById_notFound_throws() {

		when(repository.findById(99)).thenReturn(Optional.empty());
		assertThrows(PlayerNotFoundException.class, () -> service.getPlayerById(99));
	}

}
