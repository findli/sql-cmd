package JSS.w04.producer_consumer;

class Producer implements Runnable {
    private Storage storage;
    protected Thread go;

    Producer(Storage storage) {
        this.storage = storage;
        go = new Thread(this);
        go.start();
    }

    public void run() {
        int n = 0;
        //synchronized (storage) {
            while (go != null) {
                synchronized (storage) {
                    storage.setData(n);
                    System.out.println("Produced: " + n + " @ " + System.nanoTime());
                    n++;
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ie) {
                }
            }
        //}
    }

    public void stop() {
        go = null;
    }
}
