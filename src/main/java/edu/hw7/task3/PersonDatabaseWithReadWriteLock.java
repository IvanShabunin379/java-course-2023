package edu.hw7.task3;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;

public class PersonDatabaseWithReadWriteLock extends PersonDatabaseImpl {
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public void add(@NotNull Person person) {
        lock.writeLock().lock();
        try {
            super.add(person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            super.delete(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return super.findByName(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return super.findByAddress(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return super.findByPhone(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
