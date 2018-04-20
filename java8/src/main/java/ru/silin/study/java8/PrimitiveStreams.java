package ru.silin.study.java8;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * Created by konstantin.silin on 09.05.2016.
 */
public class PrimitiveStreams {
    public static void main(String[] args) {
        createExample();
        mapStreamExample();
        statisticsExamples();
    }

    private static void createExample(){
        IntStream.iterate(0, i-> ++i).limit(5).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println();
    }

    private static void mapStreamExample(){
        IntStream.rangeClosed(1, 5).mapToDouble(i -> (double) i).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 5).map(i -> i * 2).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 5).mapToObj(i -> "" + i).forEach(System.out::print);
        System.out.println();
    }

    private static void statisticsExamples(){
        OptionalDouble opt = IntStream.rangeClosed(1, 10).average();
        opt.ifPresent(System.out::println);

        IntStream.rangeClosed(1, 10).min().ifPresent(System.out::println);
        IntStream.rangeClosed(1, 10).max().ifPresent(System.out::println);

        System.out.println(IntStream.rangeClosed(1, 10).sum());

        IntSummaryStatistics stat = IntStream.rangeClosed(1, 5).summaryStatistics();
        if (stat.getCount() != 0){
            System.out.println(stat.getAverage());
            System.out.println(stat.getMax());
        }
    }
}
