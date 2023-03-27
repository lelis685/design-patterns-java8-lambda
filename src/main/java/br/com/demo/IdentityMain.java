package br.com.demo;

import br.com.demo.function.Function;

public class IdentityMain {

    public static void main(String[] args) {

        Function<String, String> identity = Function.identity();

    }
}
