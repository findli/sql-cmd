package JSS.w04.producer_consumer;

class SimpleStorage implements Storage {
    protected int inform;
    synchronized public int getData() {
        return inform;
    }
    synchronized public void setData(int value) {
        inform = value;
    }
}
