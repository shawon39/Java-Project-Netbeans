
package Threaddd;

public class TestMultitasking4 {
    public static void main(String[] args) {
        Thread th1 = new Thread(){
            @Override
            public void run(){
                System.out.println("Task One ! !!");
            }
        };
        
        Thread th2 = new Thread(){
            @Override
            public void run(){
                System.out.println("Task two ! !!");
            }
        };
        
        th1.start();
        th2.start();
    }
}
