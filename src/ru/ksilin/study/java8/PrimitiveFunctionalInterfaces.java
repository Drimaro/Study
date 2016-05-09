package ru.ksilin.study.java8;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.ToIntFunction;

/**
 * Created by konstantin.silin on 09.05.2016.
 */
public class PrimitiveFunctionalInterfaces {

    public static void main(String[] args) {
        supplierExample();

        toPrimitiveExamples();
    }

    private static void supplierExample() {
        // for boolean it is only one functional interface
        BooleanSupplier bs = () -> true;
        System.out.println(bs.getAsBoolean());
    }

    // other functional interfaces are the same as the object's. Only with addition of primitive name in interface name
    // and in method name and a lack of generics. excluding BiConsumer, BiPredicate, BiFunction.

    private static void toPrimitiveExamples() {
        ToIntFunction<String> f = x -> x.length();
        System.out.println(f.applyAsInt("test"));

        DoubleToIntFunction f2 = x -> (int) x;
        System.out.println(f2.applyAsInt(24.4));
    }
}
