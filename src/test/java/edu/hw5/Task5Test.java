package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    public void whenLicensePlateIsValidShouldReturnTrue() {
        assertThat(Task5.isValidRussianLicencePlate("А123ВЕ777")).isTrue();
        assertThat(Task5.isValidRussianLicencePlate("О777ОО177")).isTrue();
        assertThat(Task5.isValidRussianLicencePlate("Е999УХ36")).isTrue();
    }

    @Test
    public void whenLicensePlateIsInvalidShouldReturnFalse() {
        assertThat(Task5.isValidRussianLicencePlate("123АВЕ777")).isFalse();
        assertThat(Task5.isValidRussianLicencePlate("А123ВГ77")).isFalse();
        assertThat(Task5.isValidRussianLicencePlate("А123ВЕ7777")).isFalse();
        assertThat(Task5.isValidRussianLicencePlate("А123ВЕ012")).isFalse();
    }
}
