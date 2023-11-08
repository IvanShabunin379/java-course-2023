package edu.project2;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PrimGenerator implements Generator {
    @Override
    public Maze generate(int height, int width) {
        Maze maze = new Maze(height, width);
        generateMaze(maze);
        return maze;
    }

    private void generateMaze(@NotNull Maze maze) {
        List<Coordinate> frontier = new ArrayList<>();

        Coordinate start = new Coordinate(0, 0);
        frontier.add(start);

        while (!frontier.isEmpty()) {
            int randomIndex = RANDOM.nextInt(frontier.size());
            Coordinate current = frontier.get(randomIndex);

            maze.setCell(current, Cell.Type.PASSAGE);

            List<Coordinate> neighbors = getNeighbors(current, maze);

            if (!neighbors.isEmpty()) {
                int neighborIndex = RANDOM.nextInt(neighbors.size());
                Coordinate neighbor = neighbors.get(neighborIndex);

                maze.setCell(neighbor, Cell.Type.PASSAGE);

                Coordinate passage = new Coordinate(
                    (current.row() + neighbor.row()) / 2,
                    (current.col() + neighbor.col()) / 2
                );
                maze.setCell(passage, Cell.Type.PASSAGE);

                frontier.add(neighbor);
            }

            frontier.remove(randomIndex);
        }
    }

    private List<Coordinate> getNeighbors(@NotNull Coordinate current, @NotNull Maze maze) {
        int[][] directions = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}};
        List<Coordinate> neighbors = new ArrayList<>();

        for (int[] direction : directions) {
            Coordinate neighbor = current.getNextCoordinate(direction[0], direction[1]);
            if (maze.isValidLocation(neighbor) && maze.getCell(neighbor).type() == Cell.Type.WALL) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }
}

