package edu.project2;

import org.jetbrains.annotations.NotNull;

public record Coordinate(int row, int col) {
    public @NotNull Coordinate getNextCoordinate(int i, int j) {
        return new Coordinate(row() + i, col() + j);
    }
}
