package com.awatansh.game.battleship.model;

import com.awatansh.game.battleship.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerChanceTarget {

    final Player targetPlayer;
    final Coordinate target;
}
