package com.awatansh.game.battleship.exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
    }

    public InvalidInputException(NumberFormatException exception) {
        super(exception);
    }
}
