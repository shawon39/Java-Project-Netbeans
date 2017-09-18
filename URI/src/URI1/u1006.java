package URI1;

import java.util.Scanner;

public class u1006 {
    static Scanner myScanner=new Scanner(System.in);
    public static void main(String[] args) {
        double firstNumber,secondNumber,thirdNumber;
        firstNumber=myScanner.nextDouble();
        secondNumber=myScanner.nextDouble();
        thirdNumber=myScanner.nextDouble();
        double result = ((firstNumber*2)+(secondNumber*3)+(thirdNumber*5))/(2+3+5);
        System.out.printf("MEDIA = %.1f\n",result);
    }
}

