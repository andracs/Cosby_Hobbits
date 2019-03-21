/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-03-21/03/2019
 *
 */

public class Hobbit implements WeatherObserver, Runnable{

    private String name;
    private boolean hartojpaa = true;
    private WeatherType hobbittensOpfattelseAfVejret;

    public Hobbit(String name) {
        this.name = name;
        System.out.println(name + " er født.");

    }

    @Override
    public void update(WeatherType w) {
        System.out.println("Mmmm... " + name + " nyder varmen.");
        hobbittensOpfattelseAfVejret = w;
    }

    @Override
    public void run() {


            if (hartojpaa && hobbittensOpfattelseAfVejret == WeatherType.SUNNY){
                System.out.println(name + " Smider tøjet");
                hartojpaa = false;
            }


    }
}
