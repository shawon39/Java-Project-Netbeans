package t5;

public class Recursion {

    static int count = 0,ct=0;

    static void lol() {
        System.out.println("Called: " + ct);
        ct++; 
        while (count <= 5) {
            System.out.println("Hello " + count);
            count++;
            lol();
        }
    }
    public static void main(String[] args) {
        lol();
    }
}
