
package Atest;

public class BufferBuilderEfficientTest {
    
    public static String StringBuff(){
        StringBuffer sbb = new StringBuffer("java");
        for(int i=0; i<10000; i++){
            sbb.append("java");
        }
        return sbb.toString();
    }
    
    public static String StringBuil(){
        StringBuilder sb =new StringBuilder("java");
        for(int i=0; i<10000; i++){
            sb.append("java");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuff();
        System.out.println("StringBuffer: "+(System.currentTimeMillis()-startTime));
        startTime=System.currentTimeMillis();
        StringBuil();
        System.out.println("String Builder: "+(System.currentTimeMillis()-startTime));
    }
}
