package edu.hw5.task5;

import org.jetbrains.annotations.NotNull;

public final class LicensePlateValidator {
    private LicensePlateValidator() {
    }

    public static boolean isValidRussianLicencePlate(@NotNull String licencePlate) {
        return licencePlate.matches("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}[1-9]?\\d{2}$");
    }
}
