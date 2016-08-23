/**
 * Created by webonise on 23/8/16.
 */

public class QuickSort  {
    private int[] array1;
    private int len;

    public void sort(int[] inputArray) throws Exception {

        if (inputArray ==null || inputArray.length==0){
            throw new InvalidInputTypeException("empty array is input");
        }
        this.array1 = inputArray;
        len = inputArray.length;
        quicksort(0, len - 1);
    }

    private void quicksort(int low, int high) throws Exception{

        if(low > high)
            throw new IndexOutOfBoundTypeException("low > high ");

        int i = low, j = high;

        int pivot = array1[low + (high-low)/2];


        while (i <= j) {
            while (array1[i] < pivot) {
                i++;
            }
            while (array1[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) throws Exception{
        if(i == j)
            throw new SwappingSameElementTypeException("i = j for swapping purpose");
        int temp = array1[i];
        array1[i] = array1[j];
        array1[j] = temp;
    }
} 

