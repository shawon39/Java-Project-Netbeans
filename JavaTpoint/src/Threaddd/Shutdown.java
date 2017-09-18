package Threaddd;

public class Shutdown extends Thread {

    @Override
    public void run() {
        System.out.println("shut down hook task completed..");
    }
}

class test2 {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new Shutdown());
        System.out.println("Now main sleeping... press ctrl+c to exit");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}
