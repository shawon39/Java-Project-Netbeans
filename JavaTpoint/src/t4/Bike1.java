package t4;

class Bike1 {

    int speedlimit = 90;
}

class Honda3 extends Bike1 {

    int speedlimit = 150;

    public static void main(String args[]) {
        Bike1 obj = new Honda3();
        System.out.println(obj.speedlimit); //90  
    }
}