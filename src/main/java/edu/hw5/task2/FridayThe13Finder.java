package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class FridayThe13Finder {
    private static final int NUMBER_OF_MONTH_IN_YEAR = 12;

    @SuppressWarnings("MagicNumber")
    private static final TemporalAdjuster NEXT_FRIDAY_THE_13 = TemporalAdjusters.ofDateAdjuster(date -> {
        LocalDate currentThirteen = date.withDayOfMonth(13);
        if (!currentThirteen.isAfter(date)) {
            currentThirteen = currentThirteen.plusMonths(1);
        }

        while (!currentThirteen.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            currentThirteen = currentThirteen.plusMonths(1);
        }

        return currentThirteen;
    });

    private FridayThe13Finder() {
    }

    @SuppressWarnings("MagicNumber")
    public static @NotNull List<LocalDate> findALlFridaysThe13InYear(int year) {
        List<LocalDate> result = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_MONTH_IN_YEAR; ++i) {
            LocalDate currentFriday = LocalDate.of(year, i, 13);
            if (currentFriday.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result.add(currentFriday);
            }
        }

        return result;
    }

    public static LocalDate findNextFridayThe13(@NotNull LocalDate date) {
        return date.with(NEXT_FRIDAY_THE_13);

//        LocalDate currentFriday = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
//        while (currentFriday.getDayOfMonth() != 13) {
//            currentFriday = currentFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
//        }
//        return currentFriday;
    }
}
