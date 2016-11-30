package JSS.w04;

import java.util.ArrayList;
import java.util.List;


public class demoSync {

    static class MyThread implements Runnable {
        @Override
        public void run() {

               while (true ) {
                   transfer( 1, 2, 1000);
               }

        }
    }

    static List<Integer> accounts = new ArrayList<Integer>(10);

    boolean condition = false;

    // Not re-enterable
    static synchronized void transfer(int from, int to, int amount) {
        if (accounts.get(from) > amount ) {
            // Thread 1 RUNNABLE
            accounts.set(from, accounts.get(from)-amount);
            accounts.set(to, accounts.get(to)+amount);

        }
    }


    // Thread 1
    synchronized void method(){

        while (!condition) {

            try {
                this.wait(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    // Thread 2
    synchronized void method2(){

        this.condition = true;
        this.notify();


    }

    void method1() {

    }


    public static void main(String[] args) {

    }
}
