package BubbleSort;

public class BubbleSort {

    public static void main(String[] args) {

        int[] num = {19, 5, 7, 1, 16, 4, 8, 76};
        int temp;
        for (int i = 0; i < num.length - 1; i++) {

            for (int j = 0; j < num.length - 1 - i; j++) {

                if (num[j] > num[j + 1]) {

                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;                     
                }   
            }
        }
        System.out.print("Bubble Sort:");
        
        for (int i = 0; i < num.length; i++) {
            System.out.print(" " + num[i]);
        }
        System.out.println("");
    }
}
