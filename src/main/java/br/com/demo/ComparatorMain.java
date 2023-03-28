package br.com.demo;

import br.com.demo.function.Comparator;
import br.com.demo.function.Function;
import br.com.demo.model.Person;

public class ComparatorMain {

    public static void main(String[] args) {

        Person marco = new Person("marco", 26);
        Person alda = new Person("alda", 28);
        Person maria = new Person("maria", 46);

        Function<Person, String> getName = p -> p.getName();
        Function<Person, Integer> getAge = p -> p.getAge();

        Comparator<Person> compName = Comparator.comparing(getName);
        Comparator<Person> comparatorRev = compName.reversed();

        System.out.println("marco > alda :" + (compName.compare(marco, alda) > 0));
        System.out.println("alda > maria :" + (compName.compare(alda, maria) > 0));

        System.out.println("marco > alda :" + (comparatorRev.compare(marco, alda) > 0));
        System.out.println("alda > maria :" + (comparatorRev.compare(alda, maria) > 0));

        Comparator<Person> comparatorAge = Comparator.comparing(getAge);

        System.out.println("marco > alda :" + (comparatorAge.compare(marco, alda) > 0));
        System.out.println("alda > maria :" + (comparatorAge.compare(alda, maria) > 0));


        Comparator<Person> comparatorAgeAndName = compName.thenComparing(comparatorAge);
        System.out.println("marco > alda :" + (comparatorAgeAndName.compare(marco, alda) > 0));
        System.out.println("alda > maria :" + (comparatorAgeAndName.compare(alda, maria) > 0));

        Comparator<Person> comparatorAgeAndName2 =
                Comparator.comparing(getAge).thenComparing(getName);


        System.out.println("marco > alda :" + (comparatorAgeAndName2.compare(marco, alda) > 0));
        System.out.println("alda > maria :" + (comparatorAgeAndName2.compare(alda, maria) > 0));

    }


}
