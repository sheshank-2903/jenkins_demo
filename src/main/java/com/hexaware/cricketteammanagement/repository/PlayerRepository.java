package com.hexaware.cricketteammanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketteammanagement.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>{

	@Modifying
	@Query("update Player p set p.playerName= :newPlayerName , p.role= :newRole, p.totalMatches= :newTotalMatches , p.teamName= :newteamName, p.country= :newCountry , p.state= :newState, p.description = :newDescription where p.jerseyNumber = :jerseyNumber")
	void updatePlayerByJerseyNumber(@Param("newPlayerName") String newPlayerName, @Param("newRole") String newRole,@Param("newTotalMatches") long newTotalMatches,@Param("newteamName") String newteamName,@Param("newCountry") String newCountry,@Param("newState") String newState,@Param("newDescription") String newDescription,@Param("jerseyNumber") long jerseyNumber);
	
}
