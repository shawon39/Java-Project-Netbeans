
package t2;


public class thisUse2 {
    public thisUse2(int x){
        System.out.println(x);
    }
    public thisUse2(){
        this(10);  
        System.out.println("This Is Test");
    }
    public thisUse2(String x){
        System.out.println(x);
    }
    public static void main(String[] args) {
        thisUse2 st = new thisUse2(); 
    }
}