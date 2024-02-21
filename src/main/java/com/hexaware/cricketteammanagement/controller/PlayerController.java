package com.hexaware.cricketteammanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteammanagement.dto.PlayerDTO;
import com.hexaware.cricketteammanagement.entity.Player;
import com.hexaware.cricketteammanagement.exception.InvalidJerseyNumberException;
import com.hexaware.cricketteammanagement.service.IPlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
	
	@Autowired
	IPlayerService playerService;
	
	Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	@PostMapping("/add-player")
	public Player addPlayer(@RequestBody PlayerDTO playerDto) {
		logger.info("PlayerController - Player added successfully");
		return playerService.addPlayer(playerDto);
	}
	
	@PutMapping("/update-player")
	public Player updatePlayer(@RequestBody PlayerDTO playerDto) {
		logger.info("PlayerController - Player updated successfully");
		return playerService.updatePlayer(playerDto);
	}
	
	@PutMapping("/update-player-JerseyId")
	public void updatePlayerByJerseyId(@RequestBody PlayerDTO playerDto) {
		logger.info("PlayerController - Player updated successfully");
		playerService.updatePlayerByJerseyNumber(playerDto);
	}
	
	
	
	@DeleteMapping("/delete-player/{playerId}")
	public boolean deletePlayerById(@PathVariable Long playerId) {
		logger.info("PlayerController - Player deleted successfully");
		return playerService.deletePlayerById(playerId);
	}
	
	@GetMapping("/get-player-by-id/{playerId}")
	public Player getPlayerById(@PathVariable Long playerId) {
		logger.info("PlayerController - Player data by Id fetched successfully");
		return playerService.getPlayerById(playerId);
	}
	
	@GetMapping("/get-player")
	public List<Player> getAllPlayer() {
		logger.info("PlayerController - All Player data fetched successfully");
		return playerService.geAllPlayer();
	}
	
	@ResponseStatus(value=HttpStatus.ALREADY_REPORTED, reason = "Invalid Jersey Number")
	@ExceptionHandler(InvalidJerseyNumberException.class)
	 	public void handleInvalidJerseyNumberException(InvalidJerseyNumberException ex) {
			logger.warn("Exception Occured while adding player Jersey Number is incorrect");
	    }
	
}
