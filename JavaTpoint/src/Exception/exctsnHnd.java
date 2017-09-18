package Exception;

public class exctsnHnd {

    void m() {
        int data = 100 / 0;
    }

    void n() {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("Exception Handled !! [smile]");
        }
    }
    public static void main(String[] args) {
        exctsnHnd obj = new exctsnHnd();
        obj.p();
        System.out.println("Normal Flow !!");
    }
}
