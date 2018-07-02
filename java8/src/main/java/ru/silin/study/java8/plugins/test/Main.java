package ru.silin.study.java8.plugins.test;

public class Main {


    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        EntityLocker locker = EntityLockerImpl.getLocker();
        Long entityId = 123L;
        Long otherEntity = 321L;

        new Thread(() -> {
            locker.lock(entityId);
            try {
                Thread.sleep(10 * 1000);
                System.out.println("In locked global entity " + ++counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.unlock(entityId);
            }
        }).start();

        new Thread(() -> {
            String action1 = "action1";
            locker.lock(entityId, action1);
            try {
                Thread.sleep(10 * 1000);
                System.out.println("In locked " + action1 + " entity " + ++counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.unlock(entityId, action1);
            }
        }).start();

        new Thread(() -> {
            String action2 = "action2";
            locker.lock(entityId, action2);
            System.out.println("In locked " + action2 + " entity " + ++counter);
            locker.unlock(entityId, action2);
        }).start();

        new Thread(() -> {
            locker.lock(otherEntity);
            System.out.println("In other entity " + ++counter);
            locker.unlock(otherEntity);
        }).start();
    }
}
