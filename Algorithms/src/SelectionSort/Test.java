
package SelectionSort;

public class Test {
    
    public static void main(String[] args) {
        
        int array[] = {3,23,3,4,34,345,4,5,5};
        int minValue, mindIndex, temp;
        
        for(int i=0; i<array.length-1; i++){
            minValue = array[i];
            mindIndex = i;
            for(int j=i+1; j<array.length; j++){
                if(minValue > array[j]){
                    minValue = array[j];
                    mindIndex = j;
                }
            }
            
            if(mindIndex > i){
                temp = array[i];
                array[i] = array[mindIndex];
                array[mindIndex] = temp;
            }
            
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value: "+array[i]);
        }
        
    }
}
 