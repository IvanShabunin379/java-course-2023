package edu.project2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeRendererTest {
    private final static Maze MAZE = new Maze(3, 3);

    @BeforeAll public static void setUp() {
        for (int i = 0; i < MAZE.getHeight(); ++i) {
            for (int j = 0; j < MAZE.getWidth(); ++j) {
                if ((i == 1 && j == 0) || (i == 1 && j == 1)) {
                    continue;
                }
                MAZE.setCell(new Coordinate(i, j), Cell.Type.PASSAGE);
            }
        }
    }

    @Test
    public void testRender() {
        Renderer renderer = new MazeRenderer();

        String result = renderer.render(MAZE);
        String expected = "OOO\n##O\nOOO\n";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testRenderWithPath() {
        Renderer renderer = new MazeRenderer();

        List<Coordinate> path = new ArrayList<>(){{
            add(new Coordinate(0, 0));
            add(new Coordinate(0, 1));
            add(new Coordinate(0, 2));
            add(new Coordinate(1, 2));
            add(new Coordinate(2, 2));
        }};

        String result = renderer.render(MAZE, path);
        String expected = "|||\n##|\nOO|\n";

        assertThat(result).isEqualTo(expected);
    }
}
