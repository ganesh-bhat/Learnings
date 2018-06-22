package com.patterns.observer;

public class Client {

    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();

        WeatherObserver observer = new WeatherObserver();
        ws.addObserver(observer);



    }
}
