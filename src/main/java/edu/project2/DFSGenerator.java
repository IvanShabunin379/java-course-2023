package edu.project2;

import org.jetbrains.annotations.NotNull;

public class DFSGenerator implements Generator {
    @Override
    public Maze generate(int height, int width) {
        Maze maze = new Maze(height, width);
        generateMaze(maze, new Coordinate(0, 0));
        return maze;
    }

    @SuppressWarnings("MagicNumber")
    private void generateMaze(@NotNull Maze maze, @NotNull Coordinate coordinate) {
        maze.setCell(coordinate, Cell.Type.PASSAGE);

        int[][] directions = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}};
        shuffleDirections(directions);

        for (int[] direction : directions) {
            Coordinate newCoordinate = coordinate.getNextCoordinate(direction[0], direction[1]);

            if (maze.isValidLocation(newCoordinate) && maze.getCell(newCoordinate).type() == Cell.Type.WALL) {
                Coordinate wallCoordinate =
                    new Coordinate(coordinate.row() + direction[0] / 2, coordinate.col() + direction[1] / 2);
                maze.setCell(wallCoordinate, Cell.Type.PASSAGE);
                generateMaze(maze, newCoordinate);
            }
        }
    }

    private void shuffleDirections(int[] @NotNull [] directions) {
        for (int i = directions.length - 1; i > 0; --i) {
            int j = RANDOM.nextInt(i + 1);
            int[] temp = directions[i];
            directions[i] = directions[j];
            directions[j] = temp;
        }
    }
}


