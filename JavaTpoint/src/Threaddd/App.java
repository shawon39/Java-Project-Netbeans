package Threaddd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private final int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Staring: " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Complited: " + id);
    }
}

public class App {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i < 11; i++) {
            executor.submit(new Processor(i));
        }
        executor.shutdown();
        System.out.println("All Tasks Submitted !!");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("All task Complited !!");
    }
}
