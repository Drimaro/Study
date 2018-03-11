package ru.ksilin.study.java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by konstantin.silin on 08.05.2016.
 */
public class BasicStreams {
    private static final String[] DATA = {"test", "test1", "test4", "test2"};

    public static void main(String[] args) {
//        terminalStreamOperations();
//
//        intermediateStreamOperations();
//
//        underlyingDataExample();

        collectingResults();
    }

    private static void terminalStreamOperations(){
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
        collectExample();
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
        Stream.of(DATA).forEach(System.out::println);
    }

    private static long reduceExample() {
        Stream.of(DATA).reduce(String::concat).ifPresent(System.out::println);
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

    private static void collectExample() {
        StringBuilder sb = Stream.of(DATA).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(sb.toString());
    }

    private static void intermediateStreamOperations(){
        filterExample();
        distinctExample();
        limitAndSkipExample();
        mapExample();
        flatMapExample();
        sortedAndPeekExample();
    }

    private static void filterExample() {
        System.out.println(Stream.of(DATA).filter(s -> s.endsWith("2")).count());
    }

    private static void distinctExample() {
        System.out.println(Stream.of("test", "test", "test").distinct().count());
    }

    private static void limitAndSkipExample() {
        System.out.println(Stream.generate(() -> "test").limit(3).skip(2).count());
    }

    private static void mapExample() {
        System.out.println(Stream.of(DATA).map(String::length).collect(Collectors.toList()));
    }

    private static void flatMapExample() {
        List<String> listOne = Arrays.asList("test");
        List<String> listTwo = Arrays.asList("test1", "test2");
        List<String> listThree = Arrays.asList("test3");
        System.out.println(Stream.of(listOne, listTwo, listThree).flatMap(l -> l.stream()).collect(Collectors.toList()));
    }

    private static void sortedAndPeekExample() {
        System.out.println(Stream.of(DATA)
                .peek(s-> System.out.print(s))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
    }

    private static void underlyingDataExample() {
        List<String> stringList = new ArrayList<>();
        stringList.add("test1");
        stringList.add("test2");
        Stream<String> stream = stringList.stream();
        stringList.add("test3");
        System.out.println("In stream : " + stream.count());
    }

    private static void collectingResults(){
        basicCollectorsExample();
        mapCollectorsExample();
        groupingAndPartitioningExample();
    }

    private static void basicCollectorsExample(){
        Stream<String> stream = Stream.of(DATA);
        System.out.println(stream.collect(Collectors.joining(", ")));
        stream = Stream.of(DATA);
        System.out.println(stream.collect(Collectors.averagingInt(String::length)));
        stream = Stream.of(DATA);
        TreeSet<String> result = stream.filter(s -> s.length()>2).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result);
    }

    private static void mapCollectorsExample(){
        Stream<String> stream = Stream.of(DATA);
        Map<Integer,String> map = stream.collect(Collectors.toMap(String::length, v -> v, (s1, s2) -> s1 + ", " + s2, TreeMap::new));
        System.out.println(map);
    }

    private static void groupingAndPartitioningExample(){
        Stream<String> stream = Stream.of(DATA);
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(String::length));
        System.out.println(map);
        stream = Stream.of(DATA);
        Map<Integer, Set<String>> mapSet = stream.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(mapSet);
        stream = Stream.of(DATA);
        TreeMap<Integer, List<String>> treeMap = stream.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(treeMap);
        stream = Stream.of(DATA);
        Map<Integer, Long> groupingCount = stream.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(groupingCount);
//        stream = Stream.of("abcd","bbcd", "dbcd","acd");
//        Map<Integer, Optional<Character>> groupingMapping = stream.collect(Collectors.groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
//        System.out.println(groupingMapping);

        stream = Stream.of(DATA);
        Map<Boolean, List<String>> partitioning = stream.collect(Collectors.partitioningBy(s -> s.length() > 4));
        System.out.println(partitioning);
        stream = Stream.of(DATA);
        Map<Boolean, Set<String>> partitioningSet = stream.collect(Collectors.partitioningBy(s -> s.length() > 8, Collectors.toSet()));
        System.out.println(partitioningSet);
    }
}
