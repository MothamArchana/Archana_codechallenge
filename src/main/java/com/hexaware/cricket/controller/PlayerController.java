package com.hexaware.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	IPlayerService service;

	@GetMapping("/get-all")
	public List<Player> getAllPlayers() {

		return service.getAllPlayers();
	}

	@PostMapping("/add")
	public Player addPlayer(@Valid @RequestBody PlayerDTO dto) {

		return service.addPlayer(dto);
	}

	@GetMapping("/getbyid/{playerId}")
	public Player getPlayerById(@PathVariable int playerId) {

		return service.getPlayerById(playerId);
	}

	@PutMapping("/update/{playerId}")
	public Player updatePlayer(@PathVariable int playerId, @Valid @RequestBody PlayerDTO dto) {

		return service.updatePlayer(playerId, dto);
	}

	@DeleteMapping("/delete/{playerId}")
	public String deletePlayer(@PathVariable int playerId) {

		return service.deletePlayer(playerId);
	}

}
