package ru.silin.study.java8.plugins.test;

public interface EntityLocker {
    boolean lock(Object id);
    boolean lock(Object id, String scope);

    void unlock(Object id);
    void unlock(Object id, String scope);
}
