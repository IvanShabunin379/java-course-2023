package edu.hw5.task3;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

public class DateParserTest {
    private static final DateParser DATE_PARSER = new DateParser();

    @Test
    public void whenStringIsInYearMonthDayFormatShouldReturnedParsedDate() {
        Optional<LocalDate> result = DATE_PARSER.parseDate("2020-10-10");
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2020, 10, 10));
        assertThat(result).isEqualTo(expected);

        result = DATE_PARSER.parseDate("2020-12-2");
        expected = Optional.of(LocalDate.of(2020, 12, 2));
        assertThat(result).isEqualTo(expected);

        result = DATE_PARSER.parseDate("1/3/1976");
        expected = Optional.of(LocalDate.of(1976, 3, 1));
        assertThat(result).isEqualTo(expected);

        result = DATE_PARSER.parseDate("1/3/20");
        expected = Optional.of(LocalDate.of(2020, 3, 1));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenStringIsInRelativeDateFormatShouldReturnedParsedDate() {
        Optional<LocalDate> result = DATE_PARSER.parseDate("tomorrow");
        Optional<LocalDate> expected = Optional.of(LocalDate.now().plusDays(1));
        assertThat(result).isEqualTo(expected);

        result = DATE_PARSER.parseDate("today");
        expected = Optional.of(LocalDate.now());
        assertThat(result).isEqualTo(expected);

        result = DATE_PARSER.parseDate("yesterday");
        expected = Optional.of(LocalDate.now().minusDays(1));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenStringIsInDaysAgoFormatShouldReturnedParsedDate() {
        Optional<LocalDate> result = DATE_PARSER.parseDate("1 day ago");
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(1));
        assertThat(result).isEqualTo(expected);

        result = DATE_PARSER.parseDate("2234 days ago");
        expected = Optional.of(LocalDate.now().minusDays(2234));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenStringIsNotInFormatFromConditionShouldReturnEmptyOptional() {
        assertThat(DATE_PARSER.parseDate("12.12.2024")).isEmpty();
        assertThat(DATE_PARSER.parseDate("11112023")).isEmpty();
        assertThat(DATE_PARSER.parseDate("qwerty")).isEmpty();
        assertThat(DATE_PARSER.parseDate("12 days after Halloween")).isEmpty();
        assertThat(DATE_PARSER.parseDate("")).isEmpty();
        assertThat(DATE_PARSER.parseDate("2023-15-15")).isEmpty();
    }
}
