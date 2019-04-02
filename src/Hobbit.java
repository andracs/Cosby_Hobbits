/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-03-21/03/2019
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hobbit implements WeatherObserver{
    Lock lock = new ReentrantLock(  );

    public static int HobbitAntal = 0;

    private String name;

    public static int getHobbitAntal(){return HobbitAntal;}

    public synchronized void setHobitAntal(){HobbitAntal++;}

    public Hobbit(String name) {
        lock.lock();
        this.name = name;
        System.out.println(name + " er født.");
        setHobitAntal();
        lock.unlock();
    }

    @Override
    public void update(WeatherType w) {
        System.out.println("Mmmm... " + name + " nyder varmen.");
    }
}
