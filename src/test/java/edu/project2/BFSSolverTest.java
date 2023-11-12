package edu.project2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class BFSSolverTest {
    private final Random random = new Random();

    @Test
    public void whenPathIsStraightShouldReturnThisPath() {
        Maze maze = new Maze(5, 5);
        maze.setCell(new Coordinate(0, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(0, 2), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(0, 3), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(1, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(1, 3), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(2, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(2, 3), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(3, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(3, 4), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(4, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(4, 3), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(4, 4), Cell.Type.PASSAGE);

        Solver solver = new BFSSolver();

        List<Coordinate> resultPath = solver.solve(maze, new Coordinate(0, 0), new Coordinate(4, 0));
        List<Coordinate> expectedPath = new ArrayList<>() {{
            add(new Coordinate(0, 0));
            add(new Coordinate(1, 0));
            add(new Coordinate(2, 0));
            add(new Coordinate(3, 0));
            add(new Coordinate(4, 0));
        }};

        assertThat(resultPath).isEqualTo(expectedPath);
    }

    @Test
    public void whenPathIsNotStraightShouldReturnRightPath() {
        Maze maze = new Maze(5, 5);
        maze.setCell(new Coordinate(0, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(0, 2), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(0, 3), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(0, 4), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(1, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(1, 4), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(2, 0), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(2, 1), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(2, 2), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(2, 4), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(3, 2), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(3, 4), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(4, 2), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(4, 3), Cell.Type.PASSAGE);
        maze.setCell(new Coordinate(4, 4), Cell.Type.PASSAGE);

        Solver solver = new BFSSolver();

        List<Coordinate> resultPath = solver.solve(maze, new Coordinate(0, 0), new Coordinate(4, 4));
        List<Coordinate> expectedPath = new ArrayList<>() {{
            add(new Coordinate(0, 0));
            add(new Coordinate(1, 0));
            add(new Coordinate(2, 0));
            add(new Coordinate(2, 1));
            add(new Coordinate(2, 2));
            add(new Coordinate(3, 2));
            add(new Coordinate(4, 2));
            add(new Coordinate(4, 3));
            add(new Coordinate(4, 4));
        }};

        assertThat(resultPath).isEqualTo(expectedPath);
    }

    @RepeatedTest(500)
    public void whenAllCellsInMazeAreWallShouldReturnEmptyPath() {
        Maze maze = new Maze(10, 10);
        Solver solver = new BFSSolver();

        Coordinate start = new Coordinate(random.nextInt(maze.getHeight()), random.nextInt(maze.getWidth()));
        Coordinate end = new Coordinate(random.nextInt(maze.getHeight()), random.nextInt(maze.getWidth()));

        assertThat(solver.solve(maze, start, end)).isEmpty();
    }

    @RepeatedTest(500)
    public void whenAllCellsInMazeArePassagesShouldReturnNotEmptyPath() {
        Maze maze = new Maze(10, 10);
        Solver solver = new BFSSolver();

        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                maze.setCell(new Coordinate(i, j), Cell.Type.PASSAGE);
            }
        }

        Coordinate start = new Coordinate(random.nextInt(maze.getHeight()), random.nextInt(maze.getWidth()));
        Coordinate end = new Coordinate(random.nextInt(maze.getHeight()), random.nextInt(maze.getWidth()));

        if (!start.equals(end)) {
            assertThat(solver.solve(maze, start, end)).isNotEmpty();
        }
    }
}
