package InnerClass;

public interface nestedInterface {

    void show();

    public interface Runable extends nestedInterface{

        void run();
    }
}

class test1 implements nestedInterface.Runable{
    @Override
    public void run(){
        System.out.println("Running !!");
    }
    @Override
    public void show(){
        System.out.println("Showing !!");
    }
    public static void main(String[] args) {
        nestedInterface.Runable nr = new test1();
        nr.run();
        nr.show();
    }
}