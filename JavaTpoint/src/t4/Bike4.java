
package t4;

class Bike7 {
    {speed = 300;}

    int speed=200;
    void lol(){
        {speed = 400;}
    }
    Bike7() {
        {speed = 200;}
        lol();
        System.out.println("speed is " + speed);
    }
    
    public static void main(String args[]) {
        Bike7 b1 = new Bike7();
        
    }
    {speed = 100;}
}
