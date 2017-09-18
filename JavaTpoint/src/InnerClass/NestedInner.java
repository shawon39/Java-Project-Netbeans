
package InnerClass;

public class NestedInner {
    static int data = 10;
    static class AnotherClass{
       void msg(){
            System.out.println("Data: "+data);
        }
       static void lol(){
           System.out.println("Static power !!");
       }
    }
    public static void main(String[] args) {
        NestedInner.AnotherClass st = new NestedInner.AnotherClass();
        st.msg();
        NestedInner.AnotherClass.lol();
    }
}
