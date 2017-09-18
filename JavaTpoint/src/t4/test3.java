
package t4;

class Shape12 {
    void draw(){
        System.out.println("Drawing...");
    }
}
class Rectangle1 extends Shape12{
    @Override
    void draw(){
        System.out.println("Rectangle Drawing...");
    }
}
class Tringle1 extends Shape12{
    @Override
    void draw(){
        System.out.println("Tringle Drawing...");
    }
}
class Circle1 extends Shape12{
    @Override
    void draw(){
        System.out.println("Circle Drawing...");
    }
}
class test3{
    public static void main(String[] args) {
        Shape12 s = new Rectangle1();
        Shape12 ss = new Tringle1();
        Shape12 sss = new Circle1();
        s.draw();
        ss.draw();
        sss.draw();
    }
}