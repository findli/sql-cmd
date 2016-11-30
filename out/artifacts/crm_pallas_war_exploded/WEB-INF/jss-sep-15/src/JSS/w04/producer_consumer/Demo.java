package JSS.w04.producer_consumer;

public class Demo {


    public static void main(String[] args) {
        Storage storage = new SyncStorage();
        Producer producer = new Producer(storage);
        Producer producer1 = new Producer(storage);
        Producer producer2 = new Producer(storage);
        Producer producer3 = new Producer(storage);
        Producer producer4 = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ie) { }
        producer.stop();
        consumer.stop();
    }


}