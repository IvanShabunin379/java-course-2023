package edu.hw3.task8;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BackwardIteratorTest {
    @Test
    public void shouldEnumerateListBackward() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));

        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
    }

    @Test
    public void whenIteratorHasNoNextShouldNextShouldThrowException() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(List.of());
        assertThatThrownBy(iterator::next).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void whenIteratorHasNoNextShouldHasNextReturnFalse() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(List.of());
        assertThat(iterator.hasNext()).isFalse();
    }
}
