/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3;

class A {

    void msg() {
        System.out.println("Hello java lol");
    }
    protected void lol() {
        System.out.println("Hello java lol");
    }
}
 class Simple extends A {

    @Override
    void msg() {
        System.out.println("Hello java");
    } 

    public static void main(String args[]) {
        Simple obj = new Simple();
        obj.msg();
        A a = new A();
        obj.lol();
        a.lol();
    }
}
