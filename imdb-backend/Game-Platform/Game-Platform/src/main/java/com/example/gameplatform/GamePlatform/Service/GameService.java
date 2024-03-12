package com.example.gameplatform.GamePlatform.Service;

import com.example.gameplatform.GamePlatform.DTOs.GameDTO;
import com.example.gameplatform.GamePlatform.DTOs.NewGameDto;
import com.example.gameplatform.GamePlatform.DTOs.RegisterDTO;
import com.example.gameplatform.GamePlatform.DTOs.UserDTO;
import com.example.gameplatform.GamePlatform.Entities.Game;
import com.example.gameplatform.GamePlatform.Entities.User;
import com.example.gameplatform.GamePlatform.Repository.GameRepository;
import com.example.gameplatform.GamePlatform.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
@Transactional
public class GameService {
    @Autowired
    GameRepository gameRepository;
    ModelMapper mapper=new ModelMapper();
    public List<GameDTO> getAllGames()
    {
        return gameRepository.findAll().stream().map(game -> mapper.map(game,GameDTO.class)).collect(Collectors.toList());
    }
    public boolean addGame(NewGameDto newGame)
    {
            Game game=mapper.map(newGame, Game.class);
            log.info("Service called addNewGame");

            String id= UUID.randomUUID().toString();
            game.setId(id);
            game.setTitle(newGame.getTitle());
            game.setDescription(newGame.getDescription());
            game.setPg(newGame.getPg());
            game.setGenre(newGame.getGenre());
            game.setBackground(newGame.getBackground());
            game.setYear(newGame.getYear());
            game.setRating(newGame.getRating());
            game.setPoster(newGame.getPoster());

            Game fromDb=gameRepository.save(game);
            return ObjectUtils.isNotEmpty(fromDb);
    }
    public List<GameDTO>getUpcomingGames()
    {
        return gameRepository.getUpcomingGames().stream().map(upcomingGame->mapper.map(upcomingGame,GameDTO.class)).collect(Collectors.toList());
    }
    public List<GameDTO>searchGameByName(String name)
    {
        return gameRepository.searchGame(name).stream().map(searchGame->mapper.map(searchGame,GameDTO.class)).collect(Collectors.toList());
    }


}

