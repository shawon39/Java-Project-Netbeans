package Threaddd;

public class ThreadJoin extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
               Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
class ThreadJoin2 extends Thread {

    @Override
    public void run() {
        for (int i = 100; i < 600; i+=100) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
            
        }
    }
    public static void main(String[] args) {
        ThreadJoin t1 = new ThreadJoin();
        ThreadJoin2 t2 = new ThreadJoin2();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }       
        t2.start();          
    }
}
