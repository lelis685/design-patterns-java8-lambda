package br.com.demo.function;

import br.com.demo.model.Meteo;

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

    default <V> Function<V, R> compose(Function<V, T> other){
        Objects.requireNonNull(other);
        return (V v) ->{
            T t = other.apply(v);
            return this.apply(t);
        };
    }
}
