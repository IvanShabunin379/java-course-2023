package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class FaultyConnection implements Connection {
    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        boolean isWorking = RANDOM.nextBoolean();
        if (isWorking) {
            System.out.println(command);
        }
        else {
            throw new ConnectionException("Connection was interrupted.");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection is closed.");
    }
}
