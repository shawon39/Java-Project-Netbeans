package MergeSort;

public class MergeSort {

    public void mergesort(int[] MyArray, int[] temp, int low, int high) {

            if (low < high) {
            int middle = (low + high) / 2;
            mergesort(MyArray, temp, low, middle);
            mergesort(MyArray, temp, middle + 1, high);
            merge(MyArray, temp, low, middle, high);
        }
    }

    public void merge(int[] MyArray, int[] temp, int low, int middle, int high){

        for (int i = low; i <= high; i++) {
            temp[i] = MyArray[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

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

        while (i <= middle) {
            MyArray[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {

        int[] temp;
        int number;
        int[] MyArray = {5,6,2,4,9,12,55,23};
        MergeSort m = new MergeSort();

        number = MyArray.length;
        temp = new int[number];
        m.mergesort(MyArray, temp, 0, number - 1);

        for (int i = 0; i < MyArray.length; i++) {
            System.out.println(MyArray[i]);
        }

    }
}
