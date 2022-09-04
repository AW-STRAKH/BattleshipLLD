package com.awatansh.game.battleship;

import com.awatansh.game.battleship.io.output.IOutputPrinter;
import com.awatansh.game.battleship.model.PlayerChanceTarget;
import com.awatansh.game.battleship.model.player.Player;
import com.awatansh.game.battleship.strategy.IPlayerPickingStrategy;
import com.awatansh.game.battleship.strategy.IWinnerStrategy;
import com.awatansh.game.battleship.exceptions.CoordinateOutOfBoundaryException;
import lombok.NonNull;

import java.util.List;

public class GameLoop {

    private final List<Player> players;
    private final IWinnerStrategy winnerStrategy;
    private final IOutputPrinter printer;
    private final IPlayerPickingStrategy nextPlayerStrategy;

    public GameLoop(@NonNull final List<Player> players, @NonNull final IWinnerStrategy winnerStrategy,
                    @NonNull final IOutputPrinter printer, @NonNull final IPlayerPickingStrategy nextPlayerStrategy) {
        this.players = players;
        this.winnerStrategy = winnerStrategy;
        this.printer = printer;
        this.nextPlayerStrategy = nextPlayerStrategy;
    }

    public void start() {
        int currentPlayerIndex = nextPlayerStrategy.firstPlayer(this.players);
        printer.printMsg("Starting game!");
        while (true) {
            final Player currentPlayer = players.get(currentPlayerIndex);
            printer.printMsg("\n\nPlayer: " + currentPlayer.getId() + " chance:");
            //which player to attack
            final PlayerChanceTarget playerChanceTarget = currentPlayer.takeChance(this.players);

            try {
                playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());
            } catch (CoordinateOutOfBoundaryException exception) {
                printer.printMsg("Hit was out of bounds.");
            }

            printer.printSelfBoard(currentPlayer);
            printer.printOpponentBoard(players, currentPlayer);

            final Player winner = winnerStrategy.getWinner(players);
            if (winner != null) {
                printer.printWinner(winner);
                break;
            }
            currentPlayerIndex = nextPlayerStrategy.pickNextPlayer(currentPlayerIndex, this.players);
        }
    }

}
