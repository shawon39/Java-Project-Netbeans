
package Threaddd;

//public class thread1 extends Thread{
//    @Override
//    public void run(){
//        System.out.println("Thread Is Running");
//    }
//    public static void main(String[] args) {
//        thread1 th = new thread1();
//        th.start();
//    }
//}
class thread1 implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is Running...");
    }
    public static void main(String[] args) {
        thread1 th =new thread1();
        Thread t = new Thread(th);
        t.start();
        System.out.println(t.isAlive());
        
    }

}