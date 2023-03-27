package br.com.demo;

import br.com.demo.function.Function;
import br.com.demo.model.Meteo;


public class FunctionMain {

    public static void main(String[] args) {

        Meteo meteo = new Meteo(10);

        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d / 5d + 32d;

        Function<Meteo, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);

        System.out.println("meteo is F " + readFahrenheit.apply(meteo));

        readFahrenheit = celsiusToFahrenheit.compose(readCelsius);

        System.out.println("meteo is F " + readFahrenheit.apply(meteo));





    }
}
