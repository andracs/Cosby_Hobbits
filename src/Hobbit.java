/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-03-21/03/2019
 *
 */

public class Hobbit implements WeatherObserver{

    private String name;

    public Hobbit(String name) {
        this.name = name;
        System.out.println(name + " er født.");

    }

    @Override
    public void update(WeatherType w) {
        System.out.println("Mmmm... " + name + " nyder varmen.");
    }
}
