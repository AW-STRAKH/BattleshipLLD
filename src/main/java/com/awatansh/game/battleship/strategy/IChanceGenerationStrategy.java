package com.awatansh.game.battleship.strategy;

import com.awatansh.game.battleship.model.player.Player;
import com.awatansh.game.battleship.model.PlayerChanceTarget;

import java.util.List;

public interface IChanceGenerationStrategy {

    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
