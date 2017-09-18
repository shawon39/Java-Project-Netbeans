
package Exception;

import java.io.*;

class M {

    void method() throws IOException {
        throw new IOException("device error");
    }
}

class Testthrows4 {

    public static void main(String args[]) throws IOException {//declare exception  
        try {
            M m = new M();
            m.method();
        } catch (Exception e) {
            System.out.println("Ok fine !!");
        }

        System.out.println("normal flow...");
    }
}