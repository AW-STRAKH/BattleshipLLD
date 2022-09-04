package com.awatansh.game.battleship.model.player;

import com.awatansh.game.battleship.model.Board;
import com.awatansh.game.battleship.strategy.IChanceGenerationStrategy;
import com.awatansh.game.battleship.model.Coordinate;
import com.awatansh.game.battleship.model.PlayerChanceTarget;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class  Player {

    private final Board board;
    private final int id;
    private final IChanceGenerationStrategy chanceGenerationStrategy;

    // this is to get all the opponents
    public PlayerChanceTarget takeChance(List<Player> allPlayers) {
        List<Player> opponents = new ArrayList<>();
        for (Player player: allPlayers) {
            if (player.getId() != getId()) {
                opponents.add(player);
            }
        }
        // this decides which opponent to attack
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }

    public void takeHit(@NonNull final Coordinate coordinate) {
        board.takeHit(coordinate);
    }
}
