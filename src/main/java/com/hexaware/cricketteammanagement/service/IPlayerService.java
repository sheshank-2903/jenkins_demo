package com.hexaware.cricketteammanagement.service;

import java.util.List;

import com.hexaware.cricketteammanagement.dto.PlayerDTO;
import com.hexaware.cricketteammanagement.entity.Player;

public interface IPlayerService {
	public Player addPlayer(PlayerDTO cricketTeamDto);
	
	public boolean deletePlayerById(long playerId);
	
	public Player updatePlayer(PlayerDTO playerDto);
	
	public List<Player> geAllPlayer();
	
	public Player getPlayerById(long playerId);
	
	public void updatePlayerByJerseyNumber(PlayerDTO playerDto);
}
