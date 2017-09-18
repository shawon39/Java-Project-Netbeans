
package t4;
public abstract class Bike2 {
    abstract void run(); // must be implementaion !!
    void lol(){
        
    }
}

class honda extends Bike2{
    @Override
    void run(){       
    }
}
class honda4 extends Bike2{
    @Override
    void run(){
        System.out.println("Method Implemantation !!");
    }
    public static void main(String[] args) {
        Bike2 h; 
        h = new honda4();
        h.run();
        h = new honda(); 
        h.run();
    }
}
