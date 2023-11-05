package edu.project2;

public record Coordinate(int row, int col) {
    public Coordinate getNextCoordinate(int i, int j) {
        return new Coordinate(row() + i, col() + j);
    }
}
