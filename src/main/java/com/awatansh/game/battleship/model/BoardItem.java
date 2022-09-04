package com.awatansh.game.battleship.model;

import com.awatansh.game.battleship.model.boundary.IBoundary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class BoardItem {

    private final String name;
    //extensible boundary for ship
    private final IBoundary boundary;

    public boolean isKilled(@NonNull final List<Coordinate> hitLocations) {
        //all the coordinates for a particular ship
        final List<Coordinate> shipCoordinates = boundary.allCoordinates();
        for (Coordinate shipCoordinate: shipCoordinates) {
            if (!hitLocations.contains(shipCoordinate)) {
                return false;
            }
        }
        return true;
    }

    // if the coordinates lies inside a ship
    public boolean containsCoordinate(@NonNull final Coordinate coordinate) {
        return this.boundary.contains(coordinate);
    }
}
