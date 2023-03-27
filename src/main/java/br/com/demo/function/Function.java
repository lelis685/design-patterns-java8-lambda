package br.com.demo.function;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other){
        Objects.requireNonNull(other);
        return (T t) ->{
            R r = this.apply(t);
            return other.apply(r);
        };
    }
}
