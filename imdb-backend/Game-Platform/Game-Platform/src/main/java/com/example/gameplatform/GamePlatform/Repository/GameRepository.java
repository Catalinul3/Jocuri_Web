package com.example.gameplatform.GamePlatform.Repository;

import com.example.gameplatform.GamePlatform.DTOs.GameDTO;
import com.example.gameplatform.GamePlatform.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,String> {
    @Query("SELECT g FROM Game g WHERE g.year>2024")
    public List<Game> getUpcomingGames();
    @Query("SELECT g FROM Game g WHERE g.name = :name")
    public List<Game>searchGame(@Param("name")String name);
}
