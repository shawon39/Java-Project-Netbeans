package t4;

interface AInterface {
    void a();
    void b();
    void c();
    void d();
}

abstract class B implements AInterface {
    @Override
    public void c() {
        System.out.println("I am C");
    }
}
abstract class C implements AInterface {
    @Override
    public void d(){
        
    }
}
class M extends B {
    @Override
    public void a() {
        System.out.println("I am a");
    }
    @Override
    public void b() {
        System.out.println("I am b");
    }
    @Override
    public void d() {
        System.out.println("I am d");
    }
}
class Test5 {
    public static void main(String args[]) {
        AInterface a = new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }
}
