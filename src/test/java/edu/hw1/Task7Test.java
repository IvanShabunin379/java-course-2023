package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Task7Test {
    @Test
    public void positiveNumberShouldReturnThisNumberWithRotatedLeftBits() {
        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7.rotateRight(200, 2)).isEqualTo(50);
    }

    @Test
    public void positiveNumberShouldReturnThisNumberWithRotatedRightBits() {
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);
    }

    @Test
    public void nonPositiveNumberShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7.rotateLeft(-17, 2);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7.rotateLeft(0, 5);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7.rotateRight(-16, 1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7.rotateRight(0, 2);
        });
    }
}
