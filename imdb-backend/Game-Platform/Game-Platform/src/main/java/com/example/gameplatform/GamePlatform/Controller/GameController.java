package com.example.gameplatform.GamePlatform.Controller;

import com.example.gameplatform.GamePlatform.DTOs.GameDTO;
import com.example.gameplatform.GamePlatform.DTOs.NewGameDto;
import com.example.gameplatform.GamePlatform.Service.GameService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService service;
    @GetMapping("/getAllGames")
    public List<GameDTO> getAllGames(){
        log.info("getAllGames has started ...");
        List<GameDTO>result=service.getAllGames();
        return result;
    }
    @PostMapping("/addGames")
    public ResponseEntity addGame(@RequestBody NewGameDto newGame)
    {
        log.info("addGame has started ...");
        return service.addGame(newGame) ?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
    @GetMapping("/getUpcomingGames")
    public List<GameDTO>getUpcomingGames(){
        log.info("getUpcomingGames has started ...");
        List<GameDTO>result=service.getUpcomingGames();
        return result;
    }
    @GetMapping("/searchGame")
    public List<GameDTO>searchGame(String name)
    {
        log.info("searchGame has started ...");
        List<GameDTO>result=service.searchGameByName(name);
        return result;
    }
}
