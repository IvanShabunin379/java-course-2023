package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (Exception ex) {
                LOGGER.error(
                    "Attempt {} of {}: Failed to execute command due to error: {}",
                    i + 1,
                    maxAttempts,
                    ex.getMessage()
                );
                if (ex instanceof ConnectionException) {
                    throw new ConnectionException("Failed to execute command due to connection error", ex);
                }
                if (i == maxAttempts - 1) {
                    LOGGER.error("Failed to execute command after {} attempts.", maxAttempts);
                }
            }
        }
    }
}
