
package t2;

class thisUse3 {

    void m(thisUse3 obj ) {
        System.out.println("method is invoked");
    }

    void p() {
        m(this);
    }

    public static void main(String args[]) {
        thisUse3 s1 = new thisUse3();
        s1.p();
    }
}
