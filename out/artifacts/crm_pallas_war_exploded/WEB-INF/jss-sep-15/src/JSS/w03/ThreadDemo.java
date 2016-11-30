package JSS.w03;

import java.util.Random;

/**
 * Created by Cyrill on 23.09.2015.
 */
public class ThreadDemo {

    static class MyActions implements Runnable {

        Thread thread = null;

        @Override
        public void run() {
            thread = Thread.currentThread();
            while (true) {
                System.out.println(" MyActions : " + new Random().nextInt());
                try {
                    thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    }


    public static void main(String[] args) {
        new Thread( new MyActions() ).start();

        for( int i=0; i<10; i++) {
            System.out.println("main : " + i);
            try {
                Thread.sleep(500);
            } catch(Exception e) {}
        }
    }
}
