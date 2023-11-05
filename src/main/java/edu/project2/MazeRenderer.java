package edu.project2;

import java.util.List;

public class MazeRenderer implements Renderer {
    @Override
    public String render(Maze maze) {
        return render(maze, null);
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] grid = maze.getGrid();

        StringBuilder result = new StringBuilder();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (path != null && path.contains(new Coordinate(row, col))) {
                    result.append('|');
                } else {
                    Cell cell = grid[row][col];
                    if (cell.type() == Cell.Type.WALL) {
                        result.append('#');
                    } else if (cell.type() == Cell.Type.PASSAGE) {
                        result.append('O');
                    }
                }
            }
            result.append('\n');
        }

        return result.toString();
    }
}

