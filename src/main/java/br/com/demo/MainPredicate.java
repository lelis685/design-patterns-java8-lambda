package br.com.demo;

import br.com.demo.function.Predicate;

public class MainPredicate {


    public static void main(String[] args) {

        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();

        Predicate<String> p3 = p1.and(p2);

        System.out.println(p3.test("hello"));
        System.out.println(p3.test(""));
        System.out.println(p3.test(null));

        Predicate<String> notP2 = p2.negate();
        Predicate<String> p4 = p1.and(notP2);

        System.out.println(p4.test("hello"));
        System.out.println(p4.test(""));
        System.out.println(p4.test(null));

    }
}
