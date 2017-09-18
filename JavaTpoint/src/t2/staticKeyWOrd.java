
package t2;

public class staticKeyWOrd {
    static int count=0;
    static{System.out.println("Hello Static !!! ");}

    public staticKeyWOrd() {
        count++;
        System.out.println(count);
    }
    
    public static void main(String[] args) {
   
        staticKeyWOrd st = new staticKeyWOrd();
        staticKeyWOrd st2 = new staticKeyWOrd();
        staticKeyWOrd st3 = new staticKeyWOrd();
    }
}
