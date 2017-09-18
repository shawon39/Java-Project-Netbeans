
package InnerClass;

public class innerMember {
     private final int data = 100;
     void lol2(){
         System.out.println("Outer Class Method");
     }
     class Inner{
         void lol(){
             System.out.println("Inner Class Method"+data);
         }
     }
     public static void main(String[] args) {
        innerMember ab = new innerMember();
        innerMember.Inner cd = ab.new Inner();
        cd.lol(); ab.lol2();
    }
}
