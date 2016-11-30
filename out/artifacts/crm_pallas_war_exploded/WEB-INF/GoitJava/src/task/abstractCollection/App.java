package task.abstractCollection;


class App {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(2);

        System.out.println("adding elements to queue: ");

        myQueue.offer(10);
        System.out.println("\noffer(10)");
        System.out.println("myQueue: " + myQueue);
        myQueue.offer(20);
        System.out.println("\noffer(20)");
        System.out.println("myQueue: " + myQueue);
        myQueue.offer(30);
        System.out.println("\noffer(30)");
        System.out.println("myQueue: " + myQueue);
        myQueue.offer(40);
        System.out.println("\noffer(40)");
        System.out.println("myQueue: " + myQueue);
        myQueue.offer(50);
        System.out.println("\noffer(50)");
        System.out.println("myQueue: " + myQueue);
        System.out.println("-------------------------------\n");

        System.out.println("delete elements using \"poll()\": ");

        myQueue.poll();
        System.out.println("\npoll()");
        System.out.println("myQueue: " + myQueue);
        myQueue.poll();
        System.out.println("\npoll()");
        System.out.println("myQueue: " + myQueue);
        System.out.println("-------------------------------\n");

        System.out.println("clear() ");
        myQueue.clear();
        System.out.println("myQueue: " + myQueue);

        System.out.println("\n****************************************************");
        System.out.println("P.S. Using other methods you can find in JUnit tests.");
    }
}