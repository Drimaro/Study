package ru.ksilin.study.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by konstantin.silin on 16.04.2016.
 */
public class ChainedComparator implements Comparator<ChainedComparator.CompareTest> {
    @Override
    public int compare(CompareTest o1, CompareTest o2) {

        /*
        Comparator<CompareTest> c = Comparator.comparing(o -> o.getId());
        c = c.thenComparing(o -> o.getName());
        return c.compare(o1, o2);
        */

        //return Comparator.comparing((CompareTest o) -> o.getId()).thenComparing(o -> o.getName()).compare(o1, o2);

        return Comparator.comparing(CompareTest::getId)
                .thenComparing(CompareTest::getName)
                .compare(o1, o2);
    }

    public static void main(String[] args) {
        int listSize = 3;
        List<CompareTest> list = createList(listSize);

        // Sort with chained comporator
        ChainedComparator c = new ChainedComparator();
        Collections.sort(list, c);
        print(list);

        list = createList(listSize);
        // Sort using method mapping
        list.sort(Comparator.comparing(CompareTest::getId));
        print(list);

        list = createList(listSize);
        // Sort using lambda
        list.sort((o1, o2) -> o1.getId() - o2.getId());
        print(list);
    }

    private static void print(List<CompareTest> list) {
        System.out.println("Print using function interface Consumer");
        list.forEach((e) -> System.out.println(e.getId() + " " + e.getName()));

        System.out.println("Print using method mapping. Requires method toString to be overriden");
        list.forEach(System.out::println);
    }

    private static List<CompareTest> createList(int size){
        Stream<CompareTest> stream = Stream.generate(() -> {
            int i = (int) (Math.random()*10);
            String name = "test" + i;
            return new CompareTest(i, name);
        });

        return stream.limit(size).collect(Collectors.toList());
    }

    static class CompareTest {
        private int id;
        private String name;

        CompareTest(int id, String name){
            this.id = id;
            this.name = name;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }

        @Override
        public String toString(){
            return id + " " + name;
        }
    }
}
