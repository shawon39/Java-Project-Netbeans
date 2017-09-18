
package t3;

public class Animal3 {  

    public Animal3() {
        System.out.println("Super Constructor !!");
    }   
    void eat(){
        System.out.println("Eating....");
    }
}

class Bird1 extends Animal3{
    
    public Bird1(){
        super();
    }
    @Override
    void eat(){
        System.out.println("Eating....");
    }
    void sing(){
        System.out.println("Singing....");
    }
    void work(){    
        super.eat();
        sing();
    }
}

class test1{
    public static void main(String[] args) {
        Bird1 b1 = new Bird1();
        b1.work();
    }
}