package com.hexaware.cricketteammanagement.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerId;
	
	@NotBlank
	private String playerName;
	
	@NotNull
	@Min(0)
	private long jerseyNumber;
	
	@NotBlank
	@Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder")
	private String role;
	
	@NotNull
	@Min(0)
	private long totalMatches;
	
	@NotBlank
	private String teamName;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String description;

	public Player() {
		super();
	}

	public Player(long playerId, @NotBlank String playerName, @NotBlank long jerseyNumber,
			@NotBlank @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder") String role, @NotBlank long totalMatches,
			@NotBlank String teamName, @NotBlank String country, @NotBlank String state, @NotBlank String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.country = country;
		this.state = state;
		this.description = description;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public long getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(long jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
