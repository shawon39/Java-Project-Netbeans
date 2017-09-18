package MergeSort;

public class MergeSort2 {

    public void mergesort(int [] MyArray,int []temp,int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = (low + high) / 2;
            // Sort the left side of the array
            mergesort(MyArray,temp,low, middle);
            // Sort the right side of the array
            mergesort(MyArray,temp,middle + 1, high);
            // Combine them both
            merge(MyArray,temp,low, middle, high);
        }
    }

    public void merge(int [] MyArray,int []temp,int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            temp[i] = MyArray[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                MyArray[k] = temp[i];
                i++;
            } else {
                MyArray[k] = temp[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            MyArray[k] = temp[i];
            k++;
            i++;
        }

    }

    public static void main(String[] args) {

        int[] temp;
        int number;
        int[] MyArray = {12, 34, 5, 65, 46, 6, 26};
        MergeSort m = new MergeSort();

        number = MyArray.length;
        temp = new int[number];
        m.mergesort(MyArray,temp,0, number - 1);

        for (int i = 0;
                i < MyArray.length;
                i++) {
            System.out.println(MyArray[i]);
        }

    }
}
