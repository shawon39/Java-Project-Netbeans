/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2;

class A5 {

    void m() {
        System.out.println(this); //prints same reference ID  
    }

    public static void main(String args[]) {
        A5 obj = new A5();
        System.out.println(obj); //prints the reference ID  
        obj.m();
    }
}
 