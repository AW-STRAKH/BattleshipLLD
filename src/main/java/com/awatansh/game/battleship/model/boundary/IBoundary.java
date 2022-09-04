package com.awatansh.game.battleship.model.boundary;

import com.awatansh.game.battleship.model.Coordinate;
import lombok.NonNull;

import java.util.List;

// validation of coordinates
// extensibiltiy
public interface IBoundary {

    boolean contains(@NonNull Coordinate coordinate);
    List<Coordinate> allCoordinates();
}
