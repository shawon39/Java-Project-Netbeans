
package t3;

class Operation {
    
    int square(int n){
        return n*n; 
    }
}

public class Circle {
    Operation op;
    double pi = 3.1416;
    
    double area(int radius){
       op = new Operation(); 
       return (pi * op.square(radius)); 
    }
    
    public static void main(String[] args) {
        Circle c = new Circle();
        double area1 = c.area(5);
        area1=Math.round(area1*100)/100.0; 
        System.out.println("Area: "+area1);
    }
}
