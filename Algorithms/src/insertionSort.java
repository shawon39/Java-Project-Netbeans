
import java.util.Scanner;


public class insertionSort {
    
    static Scanner myScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int n = myScanner.nextInt();
        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = myScanner.nextInt();
        }
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                else break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    } 
}
