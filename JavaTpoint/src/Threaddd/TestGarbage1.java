
package Threaddd;

public class TestGarbage1 {
    @Override
    public void finalize(){        
        System.out.println("Called !!"); 
    }
    public static void main(String[] args) {
        TestGarbage1 st = new TestGarbage1();
        TestGarbage1 st2 = new TestGarbage1();       
        st=null; st2=null;         
        System.gc();
    }
}
