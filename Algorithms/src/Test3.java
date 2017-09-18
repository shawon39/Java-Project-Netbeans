
import java.util.Scanner;

public class Test3 {

    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int array[][] = new int[2][20];
        int n, max_qty, m, i, j = 0;
        float max,sum=0;
        System.out.println("Enter the item");
        n = myScanner.nextInt();
        System.out.println("Enter the weight of each item..");
        for (i = 0; i < n; i++) {
            array[0][i] = myScanner.nextInt();
        }
        System.out.println("Enter the value of each item..");
        for (i = 0; i < n; i++) {
            array[1][i] = myScanner.nextInt();
        }
        System.out.println("Enter the max weight..");
        max_qty = myScanner.nextInt();

        m = max_qty;
        while(m>=0){
            max =0;
            for (i = 0; i < n; i++) {
                if (((float)array[1][i])/((float)array[0][i]) > max){
                    max =((float)array[1][i])/((float)array[0][i]);
                    j=i;
                }
            }
            if(array[0][j]>m){
                System.out.println("Quantity of each item "+(j+1)+" added "+m);
                sum+=m*max;
                m=-1;
            }
            else{
                System.out.println("Qunatity of each item "+(j+1)+ " added "+array[0][j]);
                m-=array[0][j];
                sum+=(float)array[1][j];
                array[1][j] = 0;
            }
        }
        System.out.println("Total Profit: "+sum);
        myScanner.close();
    }
}