package Threaddd;

public class Threadee extends Thread {

    @Override
    public void run() {
        System.out.println("Running....");
    }
}

class test {

    public static void main(String[] args) {
        Threadee th = new Threadee();
        Threadee th2 = new Threadee();
        th.setName("man");
        th2.setName("ball");
        System.out.println("Name of th: " + th.getName());
        System.out.println("Name Of th2: "+th2.getName());
        System.out.println("Th id: "+th.getId());
        System.out.println("Th2 id: "+th2.getId());
        
        th.start(); th2.start();
        
        th.setName("lol");
        System.out.println("Name of th: " + th.getName());
        System.out.println("Name Of th2: "+th2.getName());
        System.out.println("Th id: "+th.getId());
        System.out.println("Th2 id: "+th2.getId());
        
        
    }
}
