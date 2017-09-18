
package Threaddd;

public class ThreadGroupDemo implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        ThreadGroupDemo runnable = new ThreadGroupDemo();
        ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");
        
        Thread t1 = new Thread(tg1, runnable, "One");
        t1.start();
        Thread t2 = new Thread(tg1, runnable, "Two");
        t2.start();
        Thread t3 = new Thread(tg1, runnable, "Three"); 
        t3.start();
        
        System.out.println("Thread Group Name: "+tg1.getName());
        System.out.println("Thread 1 Name: "+t1.getName());
        System.out.println("Thread 2 Name: "+t2.getName());
        System.out.println("Thread 3 Name: "+t3.getName());
        tg1.list();
    }
}
