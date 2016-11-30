package JSS.w03;

/**
 * Created by Cyrill on 24.09.2014.
 */
public class joinDemo {

    static class FileReaderThread extends Thread {
        Thread thread = null;

        FileReaderThread(String name) {
            super(name);
        }

        Thread getThread() {
            return thread;
        }

        public void run() {
            thread = Thread.currentThread();
            for (int i = 0; i<3; i++) {
                System.out.println(thread.getName() + " : line " + i);
                try {
                    sleep(500);
                } catch (InterruptedException ie) {
                    System.out.println(thread.getName() + " interrupted");
                }
            }
            System.out.println(thread.getName() + " exits");
        }
    }

    static class Interruptor extends Thread {
        Thread thread = null;
        Interruptor(Thread thread) {this.thread = thread; }
        public void run() {
            while (true) {
                try {
                    sleep(100);
                    if (thread != null) thread.interrupt();
                } catch (InterruptedException ie) {}
            }
        }
    }

    private static void invoke(Thread thread) {
        if (thread.getState()==Thread.State.NEW) thread.start();
        while (thread.isAlive()) {
            try {
                thread.join();
            } catch (InterruptedException ie) {
                System.out.println(thread.getName() + " interrupted");
            }
        }
    }

    public static void main(String[] args) {

//        Thread reader0 = new FileReaderThread("Reader 0");
//        reader0.start();


        Thread reader1 = new FileReaderThread("Reader 1");
        new Interruptor(reader1).start();
        invoke( reader1 );
//
//        invoke( new FileReaderThread("Reader 2") );
//        invoke( new FileReaderThread("Reader 3") );



//        Thread reader4 = new FileReaderThread("Reader 4");
//        reader4.start();
//        Thread reader5 = new FileReaderThread("Reader 5");
//        reader5.start();
//        invoke(reader4);
//        invoke(reader5);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {}

        System.out.println("main thread exits");

        System.exit(0);

    }

}
