package edu.hw2.task2;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {
    static Stream<Arguments> rectangles() {
        return Stream.of(
            Arguments.of(new Rectangle(10, 20)),
            Arguments.of(new Square(10))
        );
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);

        double expectedArea = 200.0;
        double actualArea = rect.area();

        assertThat(expectedArea).isEqualTo(actualArea);
    }
}
