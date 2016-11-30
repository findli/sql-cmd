package JSS.w04.producer_consumer;

class SyncStorage implements Storage {
    private int data = -1;
    private boolean ready;

    synchronized public int getData() {
        while (!ready) {   // count < 1
            try {
                wait(1000);
            } catch (InterruptedException ie) { }
        }
        ready = false;
        int value = data;
        notify();
        return data;
    }

    synchronized public void setData(int value) {
        while (ready) {  // count >= buffer.size()
            try {
                wait(1000);
            } catch (InterruptedException ie) { }
        }
        data = value;
        ready = true;
        notify();
    }

}
