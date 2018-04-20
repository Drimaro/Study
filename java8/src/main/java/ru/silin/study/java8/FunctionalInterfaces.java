package ru.silin.study.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

/**
 * Created by konstantin.silin on 24.04.2016.
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {

        supplierExample();

        consumerExample();

        biConsumerExample();

        predicateExample();

        biPredicateExample();

        functionExample();

        biFunctionExample();

        unaryOperatorExample();

        biUnaryOperatorExample();
    }

    private static void supplierExample(){
        Supplier<String> s1 = () -> "test Supplier";
        System.out.println("Supplier test result = " + s1.get());

        Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;
        StringBuilder sb = stringBuilderSupplier.get();
        sb.append("test StringBuilder");
        System.out.println("Supplier constructor ref test result = " + sb);
    }

    private static void consumerExample(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("test Consumer");
        consumer = consumer.andThen(s ->  System.out.println(s.substring(10)));
        consumer.accept("test Consumer");
    }

    private static void biConsumerExample(){
        BiConsumer<String, Integer> biConsumer = (v1, v2) -> System.out.println(v1 + v2);
        biConsumer.accept("test BiConsumer with number parameters = ", 2);
        Map<String, Integer> consumerMap = new HashMap<>();
        biConsumer = consumerMap::put;
        biConsumer.accept("test", 12);
        System.out.println("BiConsumer with method ref result = " + consumerMap);

        biConsumer = biConsumer.andThen((v1, v2) -> System.out.println("Added key = " + v1 + " value = " + v2));
        biConsumer.accept("test2", 32);
        System.out.println("BiConsumer with method ref result and andThen = " + consumerMap);
    }

    private static void predicateExample(){
        Predicate<String> p = s -> s.contains("t");
        System.out.println("Predicate lambda result = " + p.test("testString"));
        p = String::isEmpty;
        System.out.println("Predicate method ref result = " + p.test("testString"));

        Predicate<String> combo = p.negate().and(s -> s.startsWith("ing")).or(s -> s.endsWith("ing"));
        System.out.println("Combo predicate result = " + combo.test("testString"));
    }

    private static void biPredicateExample(){
        BiPredicate<String, String> biP = String::contains;
        System.out.println("BiPredicate result = " + biP.test("testString", "test"));

        biP = biP.and((v1, v2) -> v1.length() < v2.length()).negate().or((v1, v2) -> true);
        System.out.println("BiPredicate combo result = " + biP.test("testString", "test"));
    }

    private static void functionExample(){
        Function<String, Integer> f = String::length;
        System.out.println("Function test result = " + f.apply(""));
        f = f.andThen(v -> v*2);
        System.out.println("Function test result = " + f.apply("t"));

        f = String::length;
        f = f.compose(v -> v + "addition");
        System.out.println("Function test result = " + f.apply("t"));

        Function<String, String> fstr = Function.identity();
        System.out.println("Function identity test result = " + fstr.apply("test"));
    }

    private static void biFunctionExample(){
        BiFunction<String, String, String> biF = String::concat;
        System.out.println("BiFunction test result = " + biF.apply("test", " string"));

        biF = biF.andThen(v -> v.substring(3));
        System.out.println("BiFunction andThen test result = " + biF.apply("test", " string"));
    }

    private static void unaryOperatorExample(){
        UnaryOperator<String> u = String::toUpperCase;
        System.out.println("UnaryOperator test result = " + u.apply("test"));
    }

    private static void biUnaryOperatorExample(){
        BinaryOperator<String> biU = String::concat;
        System.out.println("BinaryOperator test result = " + biU.apply("test", " string"));
    }
}

