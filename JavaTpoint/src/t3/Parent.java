
package t3;

import java.io.*;

class Parent {

    void msg() throws IOException{
        System.out.println("parent");
    }
}

class TestExceptionChild extends Parent {

    @Override
    void msg() throws IOException {
        System.out.println("TestExceptionChild");
    }

    public static void main(String args[]) throws IOException {
        Parent p = new TestExceptionChild();
        p.msg();
    }
}
