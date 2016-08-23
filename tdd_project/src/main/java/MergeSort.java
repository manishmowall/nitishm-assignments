import java.rmi.server.ExportException;

/**
     * Created by webonise on 23/8/16.
     */

    public class MergeSort {
        private int[] array1;
        private int[] array2;

        private int len;

        public void sort(int[] inputArray) throws Exception {

            if (inputArray ==null || inputArray.length==0){
                throw new InvalidInputTypeException("empty array is input");
            }

            this.array1 = inputArray;
            len = inputArray.length;
            this.array2 = new int[len];
            mergesort(0, len - 1);

        }

        private void mergesort(int low, int high) throws Exception {

            if (low < high) {

                int mid = low + (high - low) / 2;

                mergesort(low, mid);

                mergesort(mid + 1, high);

                merge(low, mid, high);
            }
        }

        private void merge(int low, int mid, int high) throws Exception{

            if(low > mid || mid > high)
                throw new IndexOutOfBoundTypeException("index out of bound");
           for (int i = low; i <= high; i++) {
                array2[i] = array1[i];
            }

            int i = low;
            int j = mid + 1;
            int k = low;

            while (i <= mid && j <= high) {
                if (array2[i] <= array2[j]) {
                    array1[k] = array2[i];
                    i++;
                } else {
                    array1[k] = array2[j];
                    j++;
                }
                k++;
            }

            while (i <= mid) {
                array1[k] = array2[i];
                k++;
                i++;
            }

        }
    }

