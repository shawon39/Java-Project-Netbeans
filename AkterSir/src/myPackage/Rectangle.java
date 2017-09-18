
package myPackage;

public class Rectangle {
    private int height;
    private int weight;
    
    public void SetData(int height, int weight){
        this.height=height;
        this.weight=weight; 
    }
    
    public void display(){
        System.out.println("Height: "+height);
        System.out.println("Weight: "+weight);
    }
    
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();      
        rec.SetData(10, 20);       
        rec.display();
        
    }
}
