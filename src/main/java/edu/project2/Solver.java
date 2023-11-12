package edu.project2;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract class Solver {
    static final int[][] DIRECTIONS
        = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    boolean[][] visited;

    public abstract List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);

    void setVisited(@NotNull Coordinate coordinate) {
        this.visited[coordinate.row()][coordinate.col()] = true;
    }

    boolean isExplored(@NotNull Coordinate coordinate) {
        return visited[coordinate.row()][coordinate.col()];
    }
}
