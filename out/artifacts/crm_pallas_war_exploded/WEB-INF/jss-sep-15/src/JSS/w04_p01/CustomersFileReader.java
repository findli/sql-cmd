package JSS.w04_p01;

import JSS.w04_p01.om.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CustomersFileReader implements Runnable {
    private File file = null;
    private int timeout = 1000;
    private List<Customer> buffer  = null;

    private Thread thread = null;


    public CustomersFileReader(File file, int timeout, List<Customer> buffer) {
        this.file = file;
        this.timeout = timeout;
        this.buffer = buffer;

        thread = new Thread(this);
        thread.start();

    }


    @Override
    public void run() {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                synchronized (buffer) {
                    buffer.add(new Customer(sc.next(), sc.next(), sc.nextInt()));
                    buffer.notifyAll();
                }
                try {
                    //thread.sleep(timeout);
                    synchronized (buffer) {
                        buffer.wait();
                    }
                    thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
