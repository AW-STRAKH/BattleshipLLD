package com.awatansh.game.battleship.strategy;

import com.awatansh.game.battleship.model.player.Player;

import java.util.List;

public interface IWinnerStrategy {

    Player getWinner(List<Player> playerList);
}
