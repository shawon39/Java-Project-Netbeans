package SelectionSort;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {-1, 6, 24, 9, 22, 45, -15, -17, 0, 3, 4, 1, 8};
        int i, j, minValue, minIndex, temp;

        for (i = 0; i < array.length - 1; i++) {

            minValue = array[i];
            minIndex = i;

            for (j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            if (minIndex > i) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        System.out.print("Selection Sort:");
        for (int x : array) {
            System.out.print(" " + x);
        }
        System.out.println("");
    }
}
