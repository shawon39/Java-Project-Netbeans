package t2;

public class thisUse {

    void m() {
        System.out.println("Hello m");
    }

    void n() {
        System.out.println("Hello n");
        this.m();
    }
    
    public static void main(String[] args) {
        new thisUse().n(); 
    }
}
