
package t1;

public class Calculation {
    void fact(int n){
        int fact = 1;
        for(int i=1; i<=n; i++){
            fact=fact*i; 
        }
        System.out.println("Factorial: "+fact);
    }
    
    public static void main(String[] args) {
   
        new Calculation().fact(5); // Calling method with anonymous object !!
    }
}
