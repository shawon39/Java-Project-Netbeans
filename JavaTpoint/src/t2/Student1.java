
package t2;

public class Student1 {
    
    int x; 
    String y; 

    public Student1(int x,String y) {
        this.x=x;
        this.y=y; 
    }
    
    public Student1(Student1 s){
        this.x=s.x;
        this.y=s.y;
    }
    
    public void display(){
        System.out.println(x+" , "+y);
    }
    public static void main(String[] args) {
   
        Student1 lol1 = new Student1(12, "LOL MAN !!"); 
        Student1 lol2 = new Student1(lol1);
        lol1.display();
        lol2.display();
        System.out.println(Bike.x);
        System.out.println(staticKeyWOrd.count);      
    }
}
