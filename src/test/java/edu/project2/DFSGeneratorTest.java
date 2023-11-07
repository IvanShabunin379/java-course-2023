package edu.project2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DFSGeneratorTest {
    @Test
    public void shouldGenerateMazeWithInputSize() {
        Generator generator = new DFSGenerator();
        Maze maze = generator.generate(5, 5);

        assertThat(maze).isNotNull();
        assertThat(maze.getHeight()).isEqualTo(5);
        assertThat(maze.getWidth()).isEqualTo(5);
    }

    @RepeatedTest(100)
    public void shouldNotGenerateMazeWithOnlyWalls() {
        Generator generator = new DFSGenerator();
        Maze maze = generator.generate(5, 5);

        int countPassages = 0;
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getGrid()[i][j].type().equals(Cell.Type.PASSAGE)) {
                    ++countPassages;
                };
            }
        }

        assertThat(countPassages).isNotEqualTo(0);
    }

    @RepeatedTest(100)
    public void shouldNotGenerateMazeWithOnlyPassages() {
        Generator generator = new DFSGenerator();
        Maze maze = generator.generate(5, 5);

        int countWalls = 0;
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getGrid()[i][j].type().equals(Cell.Type.WALL)) {
                    ++countWalls;
                };
            }
        }

        assertThat(countWalls).isNotEqualTo(0);
    }

    @Test
    public void whenHeightOrWidthIsNonPositiveShouldThrowException() {
        Generator generator = new DFSGenerator();

        assertThatIllegalArgumentException().isThrownBy(() -> generator.generate(-5, 7));
        assertThatIllegalArgumentException().isThrownBy(() -> generator.generate(5, -5));
        assertThatIllegalArgumentException().isThrownBy(() -> generator.generate(-5, -5));
    }

}
