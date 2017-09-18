
package URI1;

import java.util.Scanner;

public class u1005 {
    static Scanner myScanner=new Scanner(System.in);
    public static void main(String[] args) {
        double firstNumber,secondNumber;
        firstNumber=myScanner.nextDouble();
        secondNumber=myScanner.nextDouble();
        double result = ((firstNumber*3.5)+(secondNumber*7.5))/(3.5+7.5);
        System.out.printf("MEDIA = %.5f\n",result);
    }
}
