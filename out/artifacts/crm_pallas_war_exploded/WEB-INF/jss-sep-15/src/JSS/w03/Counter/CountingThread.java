package JSS.w03.Counter;

/**
* Simple counting that can be paused, stopped, but cannot be started again (IllegalThreadStateException)
*/
class CountingThread extends Thread {
    private Thread counter = null;
    private int count = 0;
    private boolean bPause = false;

    public int getCount() {
        return count;
    }

    public void stopCounting() {   // stop() is final in Thread
        Thread waitingThread = counter;
        counter = null;
        waitingThread.interrupt();
    }

    public void pauseCounting() {
        bPause = !bPause;
        counter.interrupt();
    }

    @Override
    public void run()  {
        counter = Thread.currentThread();
        while (counter != null) {
            try {
                sleep(1000);
            } catch (InterruptedException e) { System.out.println("Thread Counter interrupted : " + Thread.currentThread().getName()); }
            if (!bPause) count++;
        }
    }
}
