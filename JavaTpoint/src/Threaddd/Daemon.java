package Threaddd;

public class Daemon extends Thread {

    @Override
    public void run() {
//        if(currentThread().isDaemon()){
//            System.out.println("Daemon Thread Is Running !!");
//        }else{
//            System.out.println("User Thread IS Running !!");
//        }
        System.out.println(currentThread().isDaemon());
        System.out.println(currentThread().getName());
    }

    public static void main(String[] args) {
        Daemon t1 = new Daemon();
        Daemon t2 = new Daemon();
        Daemon t3 = new Daemon();
        t1.start();
        t2.start();
        t2.setDaemon(true); // If false i will be user Thread !!       
        t3.start();
    }
}
