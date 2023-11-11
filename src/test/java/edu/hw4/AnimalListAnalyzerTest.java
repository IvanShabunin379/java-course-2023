package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static edu.hw4.Animal.Sex;
import static edu.hw4.Animal.Type;

public class AnimalListAnalyzerTest {
    private List<Animal> animals;
    private final Animal catSonya = new Animal("Sonya", Type.CAT, Animal.Sex.F, 7, 30, 5, true);
    private final Animal dogJuliet = new Animal("Juliet", Type.DOG, Sex.F, 7, 40, 7, true);
    private final Animal birdNapoleon = new Animal("Napoleon", Type.BIRD, Sex.M, 10, 30, 4, true);
    private final Animal fishNemo = new Animal("Nemo", Type.FISH, Sex.M, 5, 10, 1, false);
    private final Animal spiderBobby = new Animal("Bobby", Type.SPIDER, Sex.M, 1, 5, 0, true);
    private final Animal catVasya = new Animal("Vasya", Type.CAT, Sex.M, 4, 40, 6, true);
    private final Animal dogZefir = new Animal("Zefir", Type.DOG, Sex.M, 10, 80, 12, false);
    private final Animal birdCleopatra = new Animal("Cleopatra", Type.BIRD, Sex.F, 5, 210, 100, true);
    private final Animal fishDori = new Animal("Dori", Type.FISH, Sex.M, 0, 7, 1, false);
    private final Animal spiderInessa = new Animal("Inessa", Type.SPIDER, Sex.F, 1, 7, 0, true);

    @BeforeEach
    public void setUpList() {
        animals = new ArrayList<>(List.of(
            catSonya,
            dogJuliet,
            birdNapoleon,
            fishNemo,
            spiderBobby,
            catVasya,
            dogZefir,
            birdCleopatra,
            fishDori,
            spiderInessa
        ));
    }

    @Test
    public void testSortAnimalsByHeight() {
        List<Animal> result = AnimalListAnalyzer.sortAnimalsByHeight(animals);
        List<Animal> expected = new ArrayList<>(List.of(
            spiderBobby,
            fishDori,
            spiderInessa,
            fishNemo,
            catSonya,
            birdNapoleon,
            dogJuliet,
            catVasya,
            dogZefir,
            birdCleopatra
        ));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFindHeaviestAnimals() {
        List<Animal> result = AnimalListAnalyzer.findHeaviestAnimals(animals, 3);
        List<Animal> expected = new ArrayList<>(List.of(
            birdCleopatra, dogZefir, dogJuliet
        ));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testCountAnimalsByTypes() {
        animals.removeLast();
        animals.removeLast();

        Map<Animal.Type, Integer> result = AnimalListAnalyzer.countAnimalsByTypes(animals);

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(Type.CAT)).isEqualTo(2);
        assertThat(result.get(Type.DOG)).isEqualTo(2);
        assertThat(result.get(Type.BIRD)).isEqualTo(2);
        assertThat(result.get(Type.FISH)).isEqualTo(1);
        assertThat(result.get(Type.SPIDER)).isEqualTo(1);
    }

    @Test
    public void testFindAnimalWithLongestName() {
        Animal result = AnimalListAnalyzer.findAnimalWithLongestName(animals);
        Animal expected = birdCleopatra;
        assertThat(result).isEqualTo(expected);

        animals.remove(birdCleopatra);
        result = AnimalListAnalyzer.findAnimalWithLongestName(animals);
        expected = birdNapoleon;
        assertThat(result).isEqualTo(expected);

        animals = new ArrayList<>();
        assertThat(AnimalListAnalyzer.findAnimalWithLongestName(animals)).isNull();
    }

    @Test
    public void testFindMoreMalesOrFemales() {
        Sex result = AnimalListAnalyzer.findMoreMalesOrFemales(animals);
        assertThat(result).isEqualTo(Sex.M);

        animals.remove(dogZefir);
        animals.remove(spiderBobby);
        result = AnimalListAnalyzer.findMoreMalesOrFemales(animals);
        assertThat(result).isNull();

        animals.remove(fishNemo);
        result = AnimalListAnalyzer.findMoreMalesOrFemales(animals);
        assertThat(result).isEqualTo(Sex.F);
    }

    @Test
    public void testFindHeaviestAnimalOfEachType() {
        Map<Type, Animal> result = AnimalListAnalyzer.findHeaviestAnimalOfEachType(animals);

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(Type.CAT)).isEqualTo(catVasya);
        assertThat(result.get(Type.DOG)).isEqualTo(dogZefir);
        assertThat(result.get(Type.BIRD)).isEqualTo(birdCleopatra);
        assertThat(result.get(Type.FISH)).isEqualTo(fishNemo);
        assertThat(result.get(Type.SPIDER)).isEqualTo(spiderBobby);
    }

    @Test
    public void testFindKthOldestAnimal() {
        Animal result = AnimalListAnalyzer.findKthOldestAnimal(animals, 3);
        assertThat(result).isEqualTo(catSonya);

        result = AnimalListAnalyzer.findKthOldestAnimal(animals, 12);
        assertThat(result).isNull();
    }

    @Test
    public void testFindHeaviestAnimalBelowK() {
        Optional<Animal> result = AnimalListAnalyzer.findHeaviestAnimalBelowK(animals, 40);
        Optional<Animal> expected = Optional.of(catSonya);
        assertThat(result).isEqualTo(expected);

        result = AnimalListAnalyzer.findHeaviestAnimalBelowK(animals, 5);
        assertThat(result).isEmpty();
    }

    @Test
    public void testFindTotalPawsOfAnimals() {
        int result = AnimalListAnalyzer.findTotalPawsOfAnimals(animals);
        assertThat(result).isEqualTo(36);
    }

    @Test
    public void testFindAnimalsWhoseAgeIsNotEqualToPaws() {
        List<Animal> result = AnimalListAnalyzer.findAnimalsWhoseAgeIsNotEqualToPaws(animals);
        List<Animal> expected = new ArrayList<>(List.of(
            catSonya,
            dogJuliet,
            birdNapoleon,
            fishNemo,
            spiderBobby,
            dogZefir,
            birdCleopatra,
            spiderInessa
        ));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFindTallAnimalsWhoCanBites() {
        List<Animal> result = AnimalListAnalyzer.findTallAnimalsWhoCanBites(animals);
        List<Animal> expected = new ArrayList<>(List.of(birdCleopatra));
        assertThat(result).isEqualTo(expected);

        animals.remove(birdCleopatra);
        result = AnimalListAnalyzer.findTallAnimalsWhoCanBites(animals);
        assertThat(result).isEmpty();
    }

    @Test
    public void testCountAnimalsWhoseWeightExceedsHeight() {
        int result = AnimalListAnalyzer.countAnimalsWhoseWeightExceedsHeight(animals);
        assertThat(result).isEqualTo(0);

        animals.add(new Animal("Giant", Type.FISH, Sex.M, 1, 5, 7, false));
        result = AnimalListAnalyzer.countAnimalsWhoseWeightExceedsHeight(animals);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testFindAnimalsWhoseNameConsistOfMoreTwoWords() {
        List<Animal> result = AnimalListAnalyzer.findAnimalsWhoseNameConsistOfMoreTwoWords(animals);
        assertThat(result).isEmpty();

        Animal catMaradona = new Animal("Diego Armando Maradona", Type.CAT, Sex.M, 7, 25, 5, true);
        animals.add(catMaradona);
        result = AnimalListAnalyzer.findAnimalsWhoseNameConsistOfMoreTwoWords(animals);
        List<Animal> expected = new ArrayList<>(List.of(catMaradona));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testHasDogLongerThanK() {
        boolean result = AnimalListAnalyzer.hasDogLongerThanK(animals, 100);
        assertThat(result).isFalse();

        animals.add(new Animal("Druzhok", Type.DOG, Sex.M, 15, 105, 17, true));
        result = AnimalListAnalyzer.hasDogLongerThanK(animals, 100);
        assertThat(result).isTrue();
    }

    @Test
    public void testFindTotalWeightOfEachAnimalTypeWithAgeInDiapason() {
        var result = AnimalListAnalyzer.findTotalWeightOfEachAnimalTypeWithAgeInDiapason(animals, 1, 9);

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(Type.CAT)).isEqualTo(11);
        assertThat(result.get(Type.DOG)).isEqualTo(7);
        assertThat(result.get(Type.BIRD)).isEqualTo(100);
        assertThat(result.get(Type.FISH)).isEqualTo(1);
        assertThat(result.get(Type.SPIDER)).isEqualTo(0);
    }

    @Test
    public void testSortAnimalsByTypeSexName() {
        List<Animal> result = AnimalListAnalyzer.sortAnimalsByTypeSexName(animals);
        List<Animal> expected = new ArrayList<>(List.of(
            catVasya,
            catSonya,
            dogZefir,
            dogJuliet,
            birdNapoleon,
            birdCleopatra,
            fishDori,
            fishNemo,
            spiderBobby,
            spiderInessa
        ));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testSpidersBiteMoreOftenThanDogs() {
        boolean result = AnimalListAnalyzer.spidersBiteMoreOftenThanDogs(animals);
        assertThat(result).isTrue();

        animals.add(new Animal("Druzhok", Type.DOG, Sex.M, 15, 105, 17, true));
        result = AnimalListAnalyzer.spidersBiteMoreOftenThanDogs(animals);
        assertThat(result).isFalse();

        animals.remove(spiderInessa);
        result = AnimalListAnalyzer.spidersBiteMoreOftenThanDogs(animals);
        assertThat(result).isFalse();
    }

    @Test
    public void testFindHeaviestFish() {
        Animal result = AnimalListAnalyzer.findHeaviestFish(animals);
        assertThat(result).isEqualTo(fishNemo);

        Animal carp = new Animal("Carp", Type.FISH, Sex.M, 2, 25, 4, false);
        Animal shark = new Animal("White Shark", Type.FISH, Sex.F, 3, 400, 777, true);
        List<Animal> fish = new ArrayList<>(List.of(carp, shark));

        result = AnimalListAnalyzer.findHeaviestFish(animals, fish);
        assertThat(result).isEqualTo(shark);
    }

    @Test
    public void testFindAnimalsWithValidationErrors() {
        Map<String, Set<ValidationError>> result = AnimalListAnalyzer.findAnimalsWithValidationErrors(animals);
        assertThat(result).isEmpty();

        animals.add(new Animal("Bruce", Type.CAT, Sex.M, 3300, 1000, 1000, true));
        animals.add(new Animal("", Type.DOG, null, 100, 50, 15, false));
        result = AnimalListAnalyzer.findAnimalsWithValidationErrors(animals);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsKey("Bruce");
        assertThat(result).containsKey("");
        assertThat(result.get("Bruce")).contains(new ValidationError("age", "The animal has invalid age."));
        assertThat(result.get("Bruce")).contains(new ValidationError("height", "The animal has invalid height."));
        assertThat(result.get("Bruce")).contains(new ValidationError("weight", "The animal has invalid weight."));
        assertThat(result.get("")).contains(new ValidationError("name", "The animal has null/empty name."));
        assertThat(result.get("")).contains(new ValidationError("sex", "The animal has null sex."));
        assertThat(result.get("")).contains(new ValidationError("age", "The animal has invalid age."));
    }

    @Test
    public void testFindAnimalsWithValidationErrorsReadable() {
        Map<String, String> result = AnimalListAnalyzer.findAnimalsWithValidationErrorsReadable(animals);
        assertThat(result).isEmpty();

        animals.add(new Animal("Bruce", Type.CAT, Sex.M, 3300, 1000, 1000, true));
        animals.add(new Animal("", Type.DOG, null, 100, 50, 15, false));
        result = AnimalListAnalyzer.findAnimalsWithValidationErrorsReadable(animals);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsKey("Bruce");
        assertThat(result).containsKey("");
        assertThat(result.get("Bruce")).contains("age");
        assertThat(result.get("Bruce")).contains("height");
        assertThat(result.get("Bruce")).contains("weight");
        assertThat(result.get("")).contains("name");
        assertThat(result.get("")).contains("sex");
        assertThat(result.get("")).contains("age");
    }
}
