
package Threaddd;

public class maltitaskMultithread extends Thread{
    @Override
    public void run(){
        System.out.println("Task One !!");
    }
}

class maltitaskMultithread1 extends Thread{
    @Override
    public void run(){
        System.out.println("Task Two !!");
    }
}

class Test{
    public static void main(String[] args) {
        maltitaskMultithread th1 = new maltitaskMultithread();
        maltitaskMultithread1 th2 = new maltitaskMultithread1();
        th1.start();
        th2.start();
    }
}