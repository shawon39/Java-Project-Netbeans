
package t5;

public class Recursion2 {
    static int call=0; 
    static int factorial(int num){
        call++;
        if(num==1) return 1;
        else{
            return num*factorial(num-1);
        }
    }
    public static void main(String[] args) {
        System.out.println("Factorial: "+factorial(5)+"\nCalled: "+call);
    }
}
