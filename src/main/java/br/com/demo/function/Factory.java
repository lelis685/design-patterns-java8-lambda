package br.com.demo.function;

import br.com.demo.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {


    static Factory<Circle> createFactory() {
        return () -> new Circle();
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <T,P> Factory<T> createFactory(Function<P, T>  function, P color) {
        return () -> function.apply(color);
    }

    default T newInstance() {
        return get();
    }


    default List<T> create5() {
        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }
}
