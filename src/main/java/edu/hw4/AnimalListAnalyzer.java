package edu.hw4;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public final class AnimalListAnalyzer {
    private AnimalListAnalyzer() {
    }

    // Задача 1.
    // Отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public static List<Animal> sortAnimalsByHeight(@NotNull List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    // Задача 2.
    // Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List<Animal>
    public static List<Animal> findHeaviestAnimals(@NotNull List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    // Задача 3.
    // Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> countAnimalsByTypes(@NotNull List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    // Задача 4.
    // У какого животного самое длинное имя -> Animal
    public static Animal findAnimalWithLongestName(@NotNull List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    // Задача 5.
    // Каких животных больше: самцов или самок -> Sex
    public static Animal.Sex findMoreMalesOrFemales(@NotNull List<Animal> animals) {
        Map<Animal.Sex, Long> countBySexes = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));

        if (countBySexes.get(Animal.Sex.M) > countBySexes.get(Animal.Sex.F)) {
            return Animal.Sex.M;
        } else if (countBySexes.get(Animal.Sex.M) < countBySexes.get(Animal.Sex.F)) {
            return Animal.Sex.F;
        } else {
            return null;
        }
    }

    // Задача 6.
    // Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public static Map<Animal.Type, Animal> findHeaviestAnimalOfEachType(@NotNull List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    // Задача 7.
    // K-е самое старое животное -> Animal
    public static Animal findKthOldestAnimal(@NotNull List<Animal> animals, int k) {
        if (k < 0 || k > animals.size() - 1) {
            return null;
        }

        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Задача 8.
    // Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
    public static @NotNull Optional<Animal> findHeaviestAnimal(@NotNull List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Задача 9.
    // Сколько в сумме лап у животных в списке -> Integer
    public static @NotNull Integer findTotalPawsOfAnimals(@NotNull List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // Задача 10.
    // Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public static List<Animal> findAnimalsWhoseAgeIsNotEqualToPaws(@NotNull List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    // Задача 11.
    // Список животных, которые могут укусить (bites == null или true) и рост которых превышает 100 см -> List<Animal>
    public static List<Animal> findTallAnimalsWhoCanBites(@NotNull List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
    }

    // Задача 12.
    // Сколько в списке животных, вес которых превышает рост -> Integer
    public static @NotNull Integer countAnimalsWhoseWeightExceedsHeight(@NotNull List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }

    // Задача 13.
    // Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public static List<Animal> findAnimalsWhoseNameConsistOfMoreTwoWords(@NotNull List<Animal> animals) {
        return animals.stream()
            .filter(animal -> {
                String[] words = animal.name().split(" ");
                return words.length > 2;
            }).toList();
    }

    // Задача 14.
    // Есть ли в списке собака ростом более k см -> Boolean
    public static boolean hasDogLongerThanK(@NotNull List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type().equals(Animal.Type.DOG) && animal.height() > k);
    }

    // Задача 15.
    // Найти суммарный вес животных каждого вида, которым от k до l лет -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> findTotalWeightOfEachAnimalTypeWithAgeInDiapason(
        @NotNull List<Animal> animals,
        int k,
        int l
    ) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // Задача 16.
    // Список животных, отсортированный по виду, затем по полу, затем по имени -> List<Animal>
    public static List<Animal> sortAnimalsByTypeSexName(@NotNull List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    // Задача 17.
    // Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если данных для ответа недостаточно, вернуть false)
    public static boolean spidersBiteMoreOftenThanDogs(@NotNull List<Animal> animals) {
        Map<Animal.Type, Long> bitingCountByTypes = animals.stream()
            .filter(Animal::bites)
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));

        return bitingCountByTypes.get(Animal.Type.SPIDER) > bitingCountByTypes.get(Animal.Type.DOG);
    }

    // Задача 18.
    // Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    @SafeVarargs public static Animal findHeaviestAnimal(List<Animal>... animals) {
        return Arrays.stream(animals)
            .flatMap(Collection::stream)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
