
package t4;

public interface printable {
    void print();
}
interface showable extends printable {
   void show(); 
}
class lol3 implements showable{
    @Override
    public void print(){
        System.out.println("Print !!");
    }
    @Override
    public void show(){
        System.out.println("Show !!");
    }
}
class lol2 extends lol3{
    
}
class test5{
    public static void main(String[] args) {
        lol2 st = new lol2();
        st.show();
        st.print();
    }
}