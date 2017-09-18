
package Threaddd;

public class PiorityThread extends Thread{
    @Override
    public void run(){
        System.out.println("Running Thread Name: "+currentThread().getName());
        System.out.println("Running Thread Priority is: "+currentThread().getPriority());
    }
    public static void main(String[] args) {
        PiorityThread p =new PiorityThread();
        PiorityThread p2 =new PiorityThread();
        p.setPriority(MIN_PRIORITY);
        p2.setPriority(MAX_PRIORITY);
        p.start();
        p2.start();
        
    }
}
