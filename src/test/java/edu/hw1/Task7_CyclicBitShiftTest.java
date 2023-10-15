package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class Task7_CyclicBitShiftTest {

    @Test
    public void positiveNumberShouldReturnThisNumberWithRotatedLeftBits() {
        assertThat(Task7_CyclicBitShift.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7_CyclicBitShift.rotateRight(200, 2)).isEqualTo(50);
    }

    @Test
    public void positiveNumberShouldReturnThisNumberWithRotatedRightBits() {
        assertThat(Task7_CyclicBitShift.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7_CyclicBitShift.rotateLeft(17, 2)).isEqualTo(6);
    }

    @Test
    public void nonPositiveNumberShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7_CyclicBitShift.rotateLeft(-17, 2);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7_CyclicBitShift.rotateLeft(0, 5);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7_CyclicBitShift.rotateRight(-16, 1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Task7_CyclicBitShift.rotateRight(0, 2);
        });
    }
}
