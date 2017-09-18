/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4;

class Bike {

    final int x; 
    static final int data; 
    void run() {
        System.out.println("running");
    }
    static {data=200;}
    public Bike() {
       x = 100; 
       System.out.println(x+" , "+data);
    }
    
}

class Honda extends Bike {

    @Override
    void run() {
        System.out.println("running safely with 100kmph");
    }

    public static void main(String args[]) {
        Honda honda = new Honda();
        honda.run();
    }
}

//final class Bike {
//}
//
//class Honda1 extends Bike {
//
//    void run() {
//        System.out.println("running safely with 100kmph");
//    }
//
//    public static void main(String args[]) {
//        Honda1 honda = new Honda();
//        honda.run();
//    }
//}
