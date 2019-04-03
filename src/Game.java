import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    static ArrayList<Runnable> runnables = new ArrayList<>();
    static Weather w = new Weather();

    public static void main(String[] args) {
        int counter = 1;

        System.out.println("Hello Orc & Hobbit World!");

        System.out.println("Viser et enum eksempel:  ");
        System.out.println(WeatherType.COLD.toString());

        System.out.println("Opretter vejr");
        System.out.println("Vejret er  " + w.getWeatherNow() + " nu.");

        System.out.println("Opretter hobitter ");
        for (int i = 0; i < 1000; i++) {
            createHobbit();
        }

        System.out.println(runnables.size());

        ExecutorService pool = Executors.newCachedThreadPool();

        for (Runnable r: runnables) {
            pool.execute(r);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Number of observers: " + w.numberOfOvservers());
        pool.shutdown();




        /*System.out.println("Vejret ændrer sig");
        System.out.println("Hobitterne kan mærke varmen på deres små kroppe");
        w.timePasses();



        System.out.println("Frodo er død, han har ikke burg fo flere vejropdateringer.");*/
    }

    public static void createHobbit(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Hobbit hobbit = new Hobbit("Hobbit");
                w.addObserver(hobbit);
            }
        };
        runnables.add(runnable);
    }
}
