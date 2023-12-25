package edu.hw10.task2.callcache;

import java.io.IOException;

public interface CallCache {
    boolean put(Object[] args, Object result) throws IOException;

    Object get(Object[] args);
}
