package JSS.w04.producer_consumer;


class Consumer implements Runnable {
    private Storage storage;
    protected Thread go;

    Consumer(Storage storage) {
        this.storage = storage;
        go = new Thread(this);
        go.start();
    }

    public void run() {
        //synchronized (storage) {
            while (go != null) {
                synchronized (storage) {
                    System.out.println("\tConsumed: " + storage.getData());
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ie) {
                }
            }
        //}
    }

    public void stop() {
        go = null;
    }
}
