package edu.hw4;

import java.util.HashSet;
import java.util.Set;

public final class AnimalValidator {
    private AnimalValidator() {
    }

    public static Set<ValidationError> findValidationErrors(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        addErrorToErrorSet(errors, AnimalValidationChecks.checkName(animal.name()));
        addErrorToErrorSet(errors, AnimalValidationChecks.checkType(animal.type()));
        addErrorToErrorSet(errors, AnimalValidationChecks.checkSex(animal.sex()));
        addErrorToErrorSet(errors, AnimalValidationChecks.checkAge(animal.type(), animal.age()));
        addErrorToErrorSet(errors, AnimalValidationChecks.checkHeight(animal.type(), animal.height()));
        addErrorToErrorSet(errors, AnimalValidationChecks.checkWeight(animal.type(), animal.weight()));

        return errors;
    }

    private static void addErrorToErrorSet(Set<ValidationError> errors, ValidationError error) {
        if (error != null) {
            errors.add(error);
        }
    }

    public static String findInvalidFields(Animal animal) {
        StringBuilder invalidFields = new StringBuilder();
        Set<ValidationError> validationErrors = findValidationErrors(animal);

        for (var error : validationErrors) {
            invalidFields.append(error.field()).append(' ');
        }

        return invalidFields.toString();
    }
}
