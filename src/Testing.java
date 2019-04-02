public class Testing {

    public static void main(String[] args) {
        Weather w = new Weather();

        //Each Runnable object creates 10 hobbits and adds them to the weatherObserverList.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String name = Integer.toString( i );
                    w.addObserver(new Hobbit( name ));
                    System.out.println("A hobbit was born and is number " + i + " from this thread");
                }//To check if all the Hobbits are born and added to observer(Checks after each threads done with loop
                //so last should be 1000
                System.out.println("Total observers: " + w.totalObservers());

            }
        };
        //Creates 100 threads which creates 10 hobbits each for a total of 1000
        for (int i = 0; i < 100; i++) {
            new Thread( runnable ).start();
        }

    }

}
