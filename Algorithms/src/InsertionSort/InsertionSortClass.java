package InsertionSort;

public class InsertionSortClass {

    public int[] insertSort(int[] list) {
        int j, key, temp;
        for (int i = 1; i < list.length; i++) {
            key = list[i];
            j = i - 1;
            while (j >= 0 && key < list[j]) {
                temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                j--;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        InsertionSortClass in = new InsertionSortClass();
        int[] list = {2, 8, 4, 1, 12, 9, 3};
        in.insertSort(list);
        System.out.print("Insertion Sorting: ");
        for(int array : list){
            System.out.print(array+" ");
        }

//        for (int i = 0; i < list.length; i++) {
//            System.out.print(" " + list[i]);
//        }
        
        System.out.println("");
    }
}
