package edu.hw7.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonDatabaseTest {

    public static final int NUMBER_OF_THREADS = 10;
    public static final String BASE_TEST_NAME = "John Doe №";
    public static final String BASE_TEST_ADDRESS = "test address ";
    public static final String BASE_TEST_PHONE_NUMBER = "test phone number ";

    public static List<Supplier<PersonDatabase>> shouldBeThreadSafe() {
        return List.of(
            PersonDatabaseWithSynchronized::new,
            PersonDatabaseWithReadWriteLock::new
        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldBeThreadSafe(Supplier<PersonDatabase> personDatabaseSupplier)
        throws InterruptedException, ExecutionException {
        var personDatabase = personDatabaseSupplier.get();

        var currentPersonId = new AtomicInteger();
        var lastAddedId = new AtomicInteger();

        List<Thread> insertThreads = new ArrayList<>();
        var readThreads = new ArrayList<CompletableFuture<DatabaseTestSearchResult>>();

        for (int i = 0; i < NUMBER_OF_THREADS; ++i) {
            insertThreads.add(new Thread(() -> {
                for (int j = 0; j < NUMBER_OF_THREADS; ++j) {
                    int id = currentPersonId.incrementAndGet();
                    personDatabase.add(new Person(
                        id,
                        BASE_TEST_NAME + id,
                        BASE_TEST_ADDRESS + id,
                        BASE_TEST_PHONE_NUMBER + id
                    ));
                    lastAddedId.set(id);
                }
            }));
        }

        for (var thread : insertThreads) {
            thread.start();
            readThreads.add(CompletableFuture.supplyAsync(() -> {
                int id = lastAddedId.get();
                return new DatabaseTestSearchResult(
                    personDatabase.findByName(BASE_TEST_NAME + id),
                    personDatabase.findByAddress(BASE_TEST_ADDRESS + id),
                    personDatabase.findByPhone(BASE_TEST_PHONE_NUMBER + id)
                );
            }));
        }

        for (var thread : insertThreads) {
            thread.join();
        }

        CompletableFuture.allOf(readThreads.toArray(CompletableFuture[]::new));

        for (var future : readThreads) {
            var result = future.get();
            assertThat(result.byAddressResult())
                .containsExactlyElementsOf(result.byNameResult())
                .containsExactlyElementsOf(result.byPhoneNumberResult());
        }
    }

    private record DatabaseTestSearchResult(
        List<Person> byNameResult,
        List<Person> byAddressResult,
        List<Person> byPhoneNumberResult
    ) {
    }
}
