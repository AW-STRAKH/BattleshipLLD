package com.awatansh.game.battleship.strategy;

import com.awatansh.game.battleship.exceptions.InvalidInputException;
import com.awatansh.game.battleship.model.player.Player;

import java.util.List;

public class RoundRobinPlayerPickingStrategy implements IPlayerPickingStrategy {

    @Override
    public Integer firstPlayer(List<Player> allPlayers) {
        if (allPlayers.size() == 0) {
            throw new InvalidInputException();
        }
        //zero player
        return 0;
    }

    @Override
    public Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers) {
        return (currentPlayerIndex + 1) % allPlayers.size();
    }
}
