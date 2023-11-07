package edu.project2;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSSolver extends Solver {
    @Override
    public List<Coordinate> solve(@NotNull Maze maze, @NotNull Coordinate start, @NotNull Coordinate end) {
        visited = new boolean[maze.getHeight()][maze.getWidth()];

        List<Coordinate> path = new ArrayList<>();
        if (explore(maze, start, end, path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(
        @NotNull Maze maze,
        @NotNull Coordinate start,
        @NotNull Coordinate end,
        @NotNull List<Coordinate> path
    ) {
        if (!maze.isValidLocation(start) || maze.isWall(start) || isExplored(start)) {
            return false;
        }

        path.add(start);
        setVisited(start);

        if (start.equals(end)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            Coordinate currentCoordinate = start.getNextCoordinate(direction[0], direction[1]);
            if (explore(maze, currentCoordinate, end, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
