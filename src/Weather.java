/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-03-21/03/2019
 *
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Weather {

    private WeatherType weatherNow;
    private ArrayList<WeatherObserver> observers;

    public Weather() {
        // Lucas siger, at spillet starter i regnvejr altid
        this.setWeatherNow(WeatherType.RAINY);
        observers = new ArrayList<WeatherObserver>();
        Lock lock = new ReentrantLock();
    }

    public synchronized void addObserver(WeatherObserver w) {
        observers.add(w);
    }

    public void removeObserver(WeatherObserver w) {
        observers.remove(w);
    }

    public void timePasses() {
        weatherNow = WeatherType.SUNNY;
        System.out.println("Vejret ændrer sig til " + weatherNow);
        notifyObservers();
    }

    private void notifyObservers() {
        if (!observers.isEmpty()) {
            for (WeatherObserver hobbit : observers) {
                hobbit.update(getWeatherNow());
            }
        }
    }

    public int numberOfOvservers(){return observers.size();}

    public WeatherType getWeatherNow() {
        return weatherNow;
    }

    public void setWeatherNow(WeatherType weatherNow) {
        this.weatherNow = weatherNow;
    }


}
