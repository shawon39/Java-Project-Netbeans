package Threaddd;

public class thread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                   Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        thread2 th = new thread2();
        thread2 th1 = new thread2();
        th.start();
        th1.start();
//        th.run();
//        th1.run();
    }
}
