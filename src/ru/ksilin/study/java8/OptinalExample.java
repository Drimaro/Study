package ru.ksilin.study.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by konstantin.silin on 24.04.2016.
 */
public class OptinalExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put(i, "test" + i);
        }

        Optional<String> o = Optional.ofNullable(map.get(5));
        o.ifPresent(System.out::println);
        System.out.println(o.orElse("test else"));
        System.out.println(o.orElseGet(() -> "test else get"));
        System.out.println(o.orElseThrow(NullPointerException::new));
        if (o.isPresent()){
            System.out.println(o.get());
        }
        System.out.println("");

        o = Optional.ofNullable(map.get(20));
        if (o.isPresent()){
            System.out.println(o.get());
        }
        o.ifPresent(System.out::println);
        System.out.println(o.orElse("test else"));
        System.out.println(o.orElseGet(() -> "test else get"));
        System.out.println(o.orElseThrow(NullPointerException::new));
    }
}
