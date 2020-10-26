/*
 * Copyright (c) 2020. Mohammed A. Shehab
 *  Website: https://users.encs.concordia.ca/~m_shehab/
 *  Contact: m_shehab@encs.concordia.ca or mohammed_shihab@daad-alumni.de
 *
 */

public class QuickSortOptimization {

    // cutoff to insertion sort, must be >= 1
    private static int INSERTION_SORT_CUTOFF = 8;
    public boolean verbose=false;
    //Set cutoff
    public QuickSortOptimization(int cutoff) {
        this.INSERTION_SORT_CUTOFF = cutoff;
    }

    // This function used to split the problem into small sub-problem.
    // Divide phase
    public int partition(int[] arr, int start, int end){
        int n  = end - start + 1;
        // Here optimization
        if (n <= INSERTION_SORT_CUTOFF) {
            // if the size of array less of equal cutoff, DO insertion
            if(verbose) {
                System.out.println("Run insertion sort at partition = " + start);
            }
            insertionSort(arr);
        }
        else {
            // Do quick sort as normal
            // Pivot can be selected randomly, but in this case I make the last
            // element is the pivot for simplicity
            int m = (end - start)/2;
            int pivot = arr[m];
            // Start searching step
            for (int i = start; i < end; i++) {
                if (arr[i] < pivot) {
                    int temp = arr[start];
                    arr[start] = arr[i];
                    arr[i] = temp;
                    start++;
                }
            }
            // Swap the last item to the most right part.
            int temp = arr[start];
            arr[start] = pivot;
            arr[end] = temp;
            if(verbose) {
                System.out.println("Run quick sort at partition = " + start);
            }
        }
        return start;
    }

    public void quickSort(int[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
        if(verbose) {
            System.out.println("Partition # "+partition);
            display(arr);
        }
    }

    // method for printing the elements
    public void display(int[] a) {
        int size = a.length;

        for (int i = 0; i < size; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    // sort using insertion sort
    private void insertionSort(int[] result) {
        for (int i = 1; i < result.length; i++) {
            int tmp = result[i];
            int j = i - 1;

            while (j >= 0 && tmp < result[j]) {
                result[j + 1] = result[j];
                --j;
            }
            result[j + 1] = tmp;
        }
    }
}
