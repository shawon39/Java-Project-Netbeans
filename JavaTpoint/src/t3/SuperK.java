package t3;

public class SuperK {

    public SuperK() {
        System.out.println("Superk Created !!");
    }
}

class lol extends SuperK{

    public lol() {
        System.out.println("Lol Created !!");
    }

}

class test2{
    public static void main(String[] args) {
        lol y = new lol(); 
    }   
}