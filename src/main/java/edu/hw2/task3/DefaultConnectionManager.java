package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double FAULTY_CONNECTION_PROBABILITY = 0.2;
    private static final Random RANDOM = new Random();

    @Override
    public Connection getConnection() {
        double chance = RANDOM.nextDouble(0, 1);
        return (chance > FAULTY_CONNECTION_PROBABILITY) ? new StableConnection() : new FaultyConnection();
    }
}

