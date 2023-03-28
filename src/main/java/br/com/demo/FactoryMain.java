package br.com.demo;

import br.com.demo.function.Factory;
import br.com.demo.model.Circle;

import java.awt.*;
import java.util.List;


public class FactoryMain {

    public static void main(String[] args) {

        Factory<Circle> factory = Factory.createFactory(Circle::new,Color.RED);

        Circle circle = factory.newInstance();

        System.out.println(circle);

        List<Circle> circles = factory.create5();

        System.out.println(circles);


    }

}
