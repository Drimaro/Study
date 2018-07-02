package ru.silin.study.java8.plugins.test;

import java.util.*;

public final class EntityLockerImpl implements EntityLocker {

    private final Map<Object, Set<String>> lockHolder = new HashMap<>();
    private static final String globalScope = "all";

    private EntityLockerImpl() {}

    static EntityLocker getLocker() {
        return new EntityLockerImpl();
    }

    @Override
    public boolean lock(Object id) {
        Objects.requireNonNull(id);
        synchronized (lockHolder) {
            while (lockHolder.containsKey(id) && !lockHolder.get(id).isEmpty()) {
                try {
                    lockHolder.wait();
                } catch (InterruptedException e) {
                    // noop
                }
            }
            return addToScope(id, globalScope);
        }
    }

    @Override
    public boolean lock(Object id, String scope) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(scope);
        synchronized (lockHolder) {
            while (lockHolder.containsKey(id) &&
                    (lockHolder.get(id).contains(scope) || lockHolder.get(id).contains(globalScope))) {
                try {
                    lockHolder.wait();
                } catch (InterruptedException e) {
                    // noop
                }
            }
            return addToScope(id, scope);
        }
    }

    private boolean addToScope(Object id, String scope) {
        boolean isAdded;
        synchronized (lockHolder) {
            Set<String> protectedCodes = lockHolder.get(id);
            if (protectedCodes == null) {
                protectedCodes = new HashSet<>();
                isAdded = protectedCodes.add(scope);
                lockHolder.put(id, protectedCodes);
            } else {
                isAdded = protectedCodes.add(scope);
            }
        }
        return isAdded;
    }

    @Override
    public void unlock(Object id) {
        unlockSync(id, globalScope);
    }

    @Override
    public void unlock(Object id, String scope) {
        unlockSync(id, scope);
    }

    private void unlockSync(Object id, String scope) {
        synchronized (lockHolder) {
            Set<String> protectedCodes = lockHolder.get(id);
            protectedCodes.remove(scope);
            if (protectedCodes.isEmpty()) lockHolder.remove(id);
            lockHolder.notifyAll();
        }
    }
}
