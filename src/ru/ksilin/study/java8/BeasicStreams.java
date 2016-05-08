package ru.ksilin.study.java8;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by konstantin.silin on 08.05.2016.
 */
public class BeasicStreams {
    private static final String[] DATA = {"test", "test1", "test4", "test2"};

    public static void main(String[] args) {
        System.out.println(countExample());
        minExample().ifPresent(System.out::println);
        maxExample().ifPresent(System.out::println);
        findAnyExample().ifPresent(System.out::println);
        findFirstExample().ifPresent(System.out::println);

        Predicate<String> predicate = s -> s.length() == 4;
        System.out.println(allMatchExample(predicate));
        System.out.println(anyMatchExample(predicate));
        System.out.println(noneMatchExample(predicate));

        forEachExample();
        System.out.println(reduceExample());
    }

    private static long countExample() {
        return Stream.of(DATA).count();
    }

    private static Optional<String> minExample() {
        return Stream.of(DATA).min((s1, s2) -> s1.length() - s2.length());
    }

    private static Optional<String> maxExample() {
        return Stream.of(DATA).max((s1, s2) -> s1.length() - s2.length());
    }

    private static Optional<String> findAnyExample() {
        return Stream.generate(() -> "test find any").findAny();
    }

    private static Optional<String> findFirstExample() {
        return Stream.generate(() -> "test find first").findFirst();
    }

    private static boolean allMatchExample(Predicate<String> predicate) {
        return Stream.of(DATA).allMatch(predicate);
    }

    private static boolean anyMatchExample(Predicate<String> predicate) {
        return Stream.of(DATA).anyMatch(predicate);
    }

    private static boolean noneMatchExample(Predicate<String> predicate) {
        return Stream.of(DATA).noneMatch(predicate);
    }

    private static void forEachExample() {
        Stream.of(DATA).forEach(System.out::print);
        System.out.println();
    }

    private static long reduceExample() {
        return Stream.of(DATA).reduce(1,
                (i, s) -> {
                    System.out.println(i + " " + s);
                    return i * s.length();
                },
                (i1, i2) -> {
                    System.out.println(i1 + " " + i2);
                    return i1 + i2;
                });
    }
}
