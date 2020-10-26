/*
 * Copyright (c) 2020. Mohammed A. Shehab
 *  Website: https://users.encs.concordia.ca/~m_shehab/
 *  Contact: m_shehab@encs.concordia.ca or mohammed_shihab@daad-alumni.de
 *
 */

public class QuickSort {
    // Variable used to print data in details
    private boolean verbose = false;
    int partition = 0;
    public QuickSort(boolean verbose) {
        this.verbose = verbose;
    }

    // This function used to split the problem into small sub-problem.
    // Divide phase
    public int partition(int[] arr, int start, int end){
        // Pivot can be selected randomly, but in this case I make the last
        // element is the pivot for simplicity
        int pivot = arr[end];
        if (this.verbose)
        {
            System.out.println("Data in partition #" + partition + " , start  " + (start+1) + " to " + end);
        }
        // Start searching step
        for(int i=start; i < end; i++){
            if(arr[i] < pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
        // Swap the last item to the most right part.
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        if (this.verbose)
        {

            display(arr);
        }
        return start;
    }

    public void quickSort(int[] arr, int start, int end){
        partition++;
        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    // method for printing the elements
    public void display(int[] a) {
        int size = a.length;

        for (int i = 0; i < size; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}
