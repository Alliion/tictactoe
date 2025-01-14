package ru.mirea.tictactoe.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mirea.tictactoe.entity.Game;
import ru.mirea.tictactoe.service.GameService;

@AllArgsConstructor
@RestController
public class GameController {
    private final GameService service;

    @CrossOrigin
    @GetMapping("/game")
    public Game getUserGame(@RequestParam(name = "user_id") String userId) {
        return service.getUserGame(userId);
    }

    @CrossOrigin
    @PostMapping("/game")
    public Game createUserGame(@RequestParam(name = "user_id") String userId) {
        return service.createGame(userId);
    }

    @CrossOrigin
    @PostMapping("/game/join")
    public Game joinGame(@RequestParam(name = "game_id") long gameId, @RequestParam(name = "user_id") String userId) {
        return service.joinGame(gameId, userId);
    }

    @CrossOrigin
    @PostMapping("/game/move")
    public Game makeMove(@RequestParam(name = "user_id") String userId, @RequestParam(name = "x")  int x, @RequestParam(name = "y") int y) {
        return service.makeMove(userId, x, y);
    }
}
