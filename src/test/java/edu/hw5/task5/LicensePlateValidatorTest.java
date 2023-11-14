package edu.hw5.task5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LicensePlateValidatorTest {
    @Test
    public void whenLicensePlateIsValidShouldReturnTrue() {
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("А123ВЕ777")).isTrue();
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("О777ОО177")).isTrue();
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("Е999УХ36")).isTrue();
    }

    @Test
    public void whenLicensePlateIsInvalidShouldReturnFalse() {
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("123АВЕ777")).isFalse();
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("А123ВГ77")).isFalse();
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("А123ВЕ7777")).isFalse();
        assertThat(LicensePlateValidator.isValidRussianLicencePlate("А123ВЕ012")).isFalse();
    }
}
