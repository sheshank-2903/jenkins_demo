package com.hexaware.cricketteammanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.cricketteammanagement.dto.PlayerDTO;
import com.hexaware.cricketteammanagement.entity.Player;
import com.hexaware.cricketteammanagement.exception.InvalidJerseyNumberException;
import com.hexaware.cricketteammanagement.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagement.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
public class PlayerServiceImp implements IPlayerService{

	@Autowired  
	PlayerRepository playerRepository;
	
	Logger logger =LoggerFactory.getLogger(PlayerServiceImp.class);
	@Override
	public Player addPlayer(PlayerDTO playerDto) {
		if(playerDto.getJerseyNumber()<=0)
			throw new InvalidJerseyNumberException("Jersey Number should not be negative or Zero");
		Player player=playerRepository.save(new Player(playerDto.getPlayerId()
																,playerDto.getPlayerName()
																,playerDto.getJerseyNumber()
																,playerDto.getRole()
																,playerDto.getTotalMatches()
																,playerDto.getTeamName()
																,playerDto.getCountry()
																,playerDto.getState()
																,playerDto.getDescription()));
		logger.info("PlayerServiceImp - Player added successfully");
		return player;
	}

	@Override
	public boolean deletePlayerById(long playerId) {
		if(playerRepository.findById(playerId).orElse(null)==null)
			throw new PlayerNotFoundException("Player not found");
		playerRepository.deleteById(playerId);
		Player cricketTeam=playerRepository.findById(playerId).orElse(null);
		logger.info("PlayerServiceImp - Player deleted successfully");
		return cricketTeam==null;
	}

	@Override
	public Player updatePlayer(PlayerDTO playerDto) {
		if(playerRepository.findById(playerDto.getPlayerId()).orElse(null)==null)
			throw new PlayerNotFoundException("Player not found");
		if(playerDto.getJerseyNumber()<=0)
			throw new InvalidJerseyNumberException("Jersey Number should not be negative");
		Player player=playerRepository.save(new Player(playerDto.getPlayerId()
				,playerDto.getPlayerName()
				,playerDto.getJerseyNumber()
				,playerDto.getRole()
				,playerDto.getTotalMatches()
				,playerDto.getTeamName()
				,playerDto.getCountry()
				,playerDto.getState()
				,playerDto.getDescription()));
		logger.info("PlayerServiceImp - Player updated successfully");
		return player;
	}

	@Override
	public List<Player> geAllPlayer() {
		logger.info("PlayerServiceImp - All Player fetched successfully");
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayerById(long playerId) {
		if(playerRepository.findById(playerId).orElse(null)==null)
			throw new PlayerNotFoundException("Player not found");
		Player player = playerRepository.findById(playerId).orElse(null);
		if(player != null)
			logger.info("PlayerServiceImp - Player data by ID fetched successfully");
		else 
			logger.info("PlayerServiceImp - Player data by ID fetch unsuccessful");
		return player;
	}

	@Transactional
	@Override
    public void updatePlayerByJerseyNumber(PlayerDTO playerDto) {
        if (playerRepository.findById(playerDto.getPlayerId()).orElse(null) == null)
            throw new PlayerNotFoundException("Player not found");

        if (playerDto.getJerseyNumber() <= 0)
            throw new InvalidJerseyNumberException("Jersey Number should not be negative");

        playerRepository.updatePlayerByJerseyNumber(
                playerDto.getPlayerName(),
                playerDto.getRole(),
                playerDto.getTotalMatches(),
                playerDto.getTeamName(),
                playerDto.getCountry(),
                playerDto.getState(),
                playerDto.getDescription(),
                playerDto.getJerseyNumber()
        );

        logger.info("PlayerServiceImp - Player updated by jersey Id successfully");
    }

}
