
package t3;

public class Animal1 {
    String color = "White"; 
}

class Bird extends Animal1{
    String color = "Black";
    
    void printColor(){
        System.out.println(color);
        System.out.println(super.color);
    }
    
}

class test{
    public static void main(String[] args) {
        Bird b = new Bird();
        b.printColor();
    }
}
