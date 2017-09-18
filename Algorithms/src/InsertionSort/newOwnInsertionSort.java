package InsertionSort;

public class newOwnInsertionSort {

    public static void main(String[] args) {

        int[] array = {0, 6, 9, 2, 45, 3, 4, 1, 8, 0};
        int i, temp;

        for (i = 0; i < array.length - 1; i++) {
            while (i >= 0 && array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                i--;
            }
        }
        System.out.print("Insersion Sort:");
        for (int x : array) {
            System.out.print(" " + x);
        }
        System.out.println("");
    }
}
