package com.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherObserver implements Observer {
    @Override
    public void update(Observable o, Object temp) {
        System.out.println("Weather has been changed to "+(Double)temp);
    }
}
