package edu.project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {
    @Test
    public void testGetNextCoordinate() {
        Coordinate coordinate = new Coordinate(0, 0);
        Coordinate nextCoordinate = coordinate.getNextCoordinate(1, 2);
        assertThat(nextCoordinate).isEqualTo(new Coordinate(1, 2));
    }
}
