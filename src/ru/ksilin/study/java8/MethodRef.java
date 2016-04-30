package ru.ksilin.study.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by konstantin.silin on 23.04.2016.
 */
public class MethodRef {

    public MethodRef(){
        System.out.println("Some constructor text");
    }

    public static void main(String[] args) {
        // Constructor
        Supplier<MethodRef> s = MethodRef::new;
        MethodRef methodRef = s.get();

        // static
        Consumer<String> c = MethodRef::staticPrint;
        c.accept("Some static text");

        // instance
        c = methodRef::print;
        c.accept("Some instance text");

        //Consumer<String> c1 = MethodRef::print; // incorrect!!!
        Consumer<MethodRef> c1 = MethodRef::print;
        c1.accept(methodRef);


    }

    public void print(String text){
        System.out.println(text);
    }

    public void print(){
        System.out.println("Some instance in runtime");
    }

    public static void staticPrint(String text) {
        System.out.println(text);
    }

    @Override
    public String toString(){
        return "test";
    }
}
