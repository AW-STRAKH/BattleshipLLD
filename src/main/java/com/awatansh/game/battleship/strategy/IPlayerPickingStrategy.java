package com.awatansh.game.battleship.strategy;

import com.awatansh.game.battleship.model.player.Player;

import java.util.List;

public interface IPlayerPickingStrategy {

    Integer firstPlayer(List<Player> allPlayers);
    Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers);
}
