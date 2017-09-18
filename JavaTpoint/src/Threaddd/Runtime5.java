package Threaddd;

public class Runtime5 {

    public static void main(String[] args) throws Exception{
        Runtime r = Runtime.getRuntime();
        System.out.println("Total Memory: "+r.totalMemory());
        System.out.println("Free Memory: "+r.freeMemory());
        for(int i=0; i<100004; i++){
            new Runtime5();
        }
        System.out.println("After Creating Instance, free memory: "+r.freeMemory());
        System.gc();
        System.out.println("After Calling gc(), Free memory: "+r.freeMemory());
    }
}
