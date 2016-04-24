package ru.ksilin.study.java8;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Drimaro on 24.04.2016.
 */
public class CollectionsIn8 {

    public static void main(String[] args) {

        Supplier<CollectionsIn8> s = CollectionsIn8::new;
        CollectionsIn8 c = s.get();

        c.execListExamples();

        c.execMapExamples();
    }

    private void execListExamples(){
        int listSize = 10;
        int wordLengthBound = 20;

        // Lists
        List<String> list = generateList(listSize, wordLengthBound);
        list.forEach(System.out::println);

        list.removeIf(s -> s.contains("a"));
        System.out.println("list size was " + listSize + " now " + list.size() + " removed " + (listSize - list.size()));

        list.replaceAll(s -> s+="-test!!");
        System.out.println(list);
    }

    private void execMapExamples(){
        // Maps
        Map<Integer, Integer> map = generateMap(5);
        map.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

        execPutIfAbsent(map);

        execMerge(map);

        execComputeIfAbsent(map);

        execComputeIfPresent(map);
    }

    private Map<Integer, Integer> execPutIfAbsent(Map<Integer, Integer> map){
        System.out.println("putIfAbsent example:");
        map.putIfAbsent(0, -999);
        System.out.print(map);
        map.put(0, null);
        map.putIfAbsent(0, -999);
        System.out.println(map);

        return map;
    }

    private Map<Integer, Integer> execMerge(Map<Integer, Integer> map){
        System.out.println("merge:");
        map.merge(0, 1000, (sv, v) -> sv > v ? sv : v);
        System.out.print(map);
        map.merge(0, 800, (sv, v) -> sv > v ? sv : v);
        System.out.print(map);
        map.put(0, null);
        map.merge(0, -800, (sv, v) -> sv > v ? sv : v);
        System.out.println(map);
        return map;
    }

    private Map<Integer, Integer> execComputeIfAbsent(Map<Integer, Integer> map){
        System.out.println("computeIfAbsent:");
        Integer computed;
        computed = map.computeIfAbsent(0, k -> 99);
        System.out.println(map + " " + computed);
        map.put(0, null);
        computed = map.computeIfAbsent(0, k -> 99);
        System.out.println(map + " " + computed);
        map.remove(0);
        computed = map.computeIfAbsent(0, k -> -1);
        System.out.println(map + " " + computed);
        map.remove(2);
        computed = map.computeIfAbsent(2, k -> null);
        System.out.println(map + " " + computed);

        return map;
    }

    private Map<Integer, Integer> execComputeIfPresent(Map<Integer, Integer> map){
        Integer computed;
        System.out.println("computeIfPresent:");
        computed = map.computeIfPresent(0, (k, v) -> v *-1);
        System.out.println(map + " " + computed);
        map.put(0, null);
        computed = map.computeIfPresent(0, (k, v) -> 4);
        System.out.println(map + " " + computed);
        map.put(0, 4);
        computed = map.computeIfPresent(0, (k, v) -> null);
        System.out.println(map + " " + computed);
        computed = map.computeIfPresent(0, (k, v) -> 1_000);
        System.out.println(map + " " + computed);

        return map;
    }


    private static List<String> generateList(int size, int lengthBound){
        Random r = new Random(new Date().getTime());

        return Stream.iterate(0, i -> i++)
                .limit(size)
                .map(i -> r.ints(r.nextInt(lengthBound), 97, 123)
                            .mapToObj(c -> String.valueOf((char)c))
                            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append))
                .map(StringBuilder::toString).collect(Collectors.toList());

    }

    private static Map<Integer, Integer> generateMap(int size){
        Random r = new Random(new Date().getTime());

        return Stream.iterate(0, i -> i++)
                .limit(size)
                .collect(Collectors.toMap(i -> i, ra -> r.nextInt()));
    }
}

