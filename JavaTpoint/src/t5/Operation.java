
package t5;

public class Operation {
    int data = 50;
    void change(Operation op){
        op.data = op.data +100;
    }
    public static void main(String[] args) {
        Operation op = new Operation();
        System.out.println("Before Change: "+op.data);
        op.change(op);
        System.out.println("After Change: "+op.data);
        
    }
}
