package InnerClass;

public class LocalInner {
    int data = 10;
    void display() {
        int data= 12;
        class Inner {
            void msg(){
                int data = 15; 
                System.out.println("Called: "+data);
            }
        }
        Inner In = new Inner();
        In.msg();
    }
    public static void main(String[] args) {
        LocalInner Lin = new LocalInner();
        Lin.display();
    }
}
