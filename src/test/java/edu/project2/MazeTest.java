package edu.project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeTest {
    @Test
    public void testIsValidLocation() {
        Maze maze = new Maze(3, 3);
        assertThat(maze.isValidLocation(new Coordinate(1, 1))).isTrue();
        assertThat(maze.isValidLocation(new Coordinate(3, 3))).isFalse();
        assertThat(maze.isValidLocation(new Coordinate(-1, 1))).isFalse();
    }

    @Test
    public void testIsWall() {
        Maze maze = new Maze(3, 3);
        maze.setCell(new Coordinate(2, 2), Cell.Type.PASSAGE);
        assertThat(maze.isWall(new Coordinate(1, 1))).isTrue();
        assertThat(maze.isWall(new Coordinate(2, 2))).isFalse();
    }
}
