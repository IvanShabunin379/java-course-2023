package edu.hw4;

public final class AnimalValidationChecks {
    private AnimalValidationChecks() {
    }

    public static ValidationError checkName(String name) {
        if (name == null || name.isEmpty()) {
            return new ValidationError("name", "The animal has null/empty name.");
        }

        String regex = "^[A-Z][a-z]+( [A-Z][a-z]+)*$";
        return (name.matches(regex)) ? null : new ValidationError("name", "The animal has invalid name.");
    }

    public static ValidationError checkType(Animal.Type type) {
        return (type != null) ? null : new ValidationError("type", "The animal has null type.");
    }

    public static ValidationError checkSex(Animal.Sex sex) {
        return (sex != null) ? null : new ValidationError("sex", "The animal has null sex.");
    }

    public static ValidationError checkAge(Animal.Type type, int age) {
        int maxValidAge = switch (type) {
            case null -> 100;
            case CAT -> 40;
            case DOG -> 35;
            case BIRD -> 71;
            case FISH -> 95;
            case SPIDER -> 45;
        };

        return (age >= 0 && age <= maxValidAge) ? null : new ValidationError("age", "The animal has invalid age.");
    }

    public static ValidationError checkHeight(Animal.Type type, int height) {
        int maxValidHeight = switch (type) {
            case null -> 2000;
            case CAT -> 50;
            case DOG -> 220;
            case BIRD -> 270;
            case FISH -> 2000;
            case SPIDER -> 30;
        };

        return (height >= 0 && height <= maxValidHeight) ? null
            : new ValidationError("height", "The animal has invalid height.");
    }

    public static ValidationError checkWeight(Animal.Type type, double weight) {
        int maxValidWeight = switch (type) {
            case null -> 2500;
            case CAT -> 21;
            case DOG, BIRD -> 130;
            case FISH -> 2300;
            case SPIDER -> 1;
        };

        return (weight >= 0 && weight <= maxValidWeight) ? null
            : new ValidationError("weight", "The animal has invalid weight.");
    }
}
