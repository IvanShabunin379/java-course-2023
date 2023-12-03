package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class PersonDatabaseImpl implements PersonDatabase {
    private final Map<Integer, Person> persons;
    private final Map<String, List<Person>> nameIndex;
    private final Map<String, List<Person>> addressIndex;
    private final Map<String, List<Person>> phoneIndex;

    public PersonDatabaseImpl() {
        persons = new HashMap<>();
        nameIndex = new HashMap<>();
        addressIndex = new HashMap<>();
        phoneIndex = new HashMap<>();
    }

    @Override
    public void add(@NotNull Person person) {
        if (!person.fieldsAreNotNull()) {
            throw new IllegalArgumentException("Person fields cannot be null.");
        }

        Person nonActualPerson = persons.put(person.id(), person);
        addToIndexes(person);

        if (nonActualPerson != null) {
            deleteFromIndexes(nonActualPerson);
        }
    }

    private void addToIndexes(Person person) {
        addToIndex(nameIndex, person.name(), person);
        addToIndex(addressIndex, person.address(), person);
        addToIndex(phoneIndex, person.phoneNumber(), person);
    }

    private void addToIndex(Map<String, List<Person>> index, String key, Person person) {
        if (!index.containsKey(key)) {
            index.put(key, new ArrayList<>());
        }

        index.get(key).add(person);
    }

    @Override
    public void delete(int id) {
        Person personBeingDeleted = persons.remove(id);

        if (personBeingDeleted != null) {
            deleteFromIndexes(personBeingDeleted);
        }
    }

    private void deleteFromIndexes(Person person) {
        deleteFromIndex(nameIndex, person.name(), person);
        deleteFromIndex(addressIndex, person.address(), person);
        deleteFromIndex(phoneIndex, person.phoneNumber(), person);
    }

    private void deleteFromIndex(Map<String, List<Person>> index, String key, Person person) {
        List<Person> personListByKey = index.get(key);

        if (personListByKey.size() != 1) {
            personListByKey.remove(person);
        } else {
            index.remove(key);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        return findInIndex(nameIndex, name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return findInIndex(addressIndex, address);
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return findInIndex(phoneIndex, phone);
    }

    private List<Person> findInIndex(Map<String, List<Person>> index, String key) {
        List<Person> result = index.get(key);
        return (result != null) ? result : new ArrayList<>();
    }
}
