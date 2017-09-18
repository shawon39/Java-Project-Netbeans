package Threaddd;

public class Myclass extends TestClass2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 500 " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
       
    }
}

class TestClass2 {

    public static void main(String[] args) throws InterruptedException{

        Myclass myclass = new Myclass();
        Thread th = new Thread(myclass);
        th.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 1000 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}
