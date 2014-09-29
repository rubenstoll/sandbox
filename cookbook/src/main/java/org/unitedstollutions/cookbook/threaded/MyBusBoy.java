package org.unitedstollutions.cookbook.threaded;

/**
 * Created by ruben on 06/08/14.
 */
public class MyBusBoy implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
//    @Override
//    public void run() {
//
//    }

    /**
     * Run does the work. We override the run() method in Runnable.
     */
    public void run() {
        while (count-- > 0) {
            System.out.println(mesg);
            try {
                Thread.sleep(100);    // 100 msec
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(mesg + " thread all done.");
    }

    private String mesg;
    private Thread t;
    private int count;

    /**
     * Main program, test driver for ThreadsDemo2 class.
     */
    public static void main(String[] argv) {
        new MyBusBoy("Hello from X", 10);
        new MyBusBoy("Hello from Y", 15);
    }


    public MyBusBoy(String m, int n) {
        count = n;
        mesg = m;
        t = new Thread(this);
        t.setName(m + " runner Thread");
        t.start();
    }



}
