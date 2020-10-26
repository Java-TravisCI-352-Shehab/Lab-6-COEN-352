/*
 * Copyright (c) 2020. Mohammed A. Shehab
 *  Website: https://users.encs.concordia.ca/~m_shehab/
 *  Contact: m_shehab@encs.concordia.ca or mohammed_shihab@daad-alumni.de
 *
 */

import java.util.Random;

public class Driver {

    static final double DIV_FACTOR = 1000000000.0;

    // Function to problem on slide# 21
    public static void test_QuickSort_Optimization(int data_size)
    {
        Random rn = new Random();
        int[] arr = new int[data_size];
        double time = 0.0;
        // init array
        for (int i = 0; i < data_size; ++i)
        {
            arr[i] = rn.nextInt(10000);
        }
        double minimum_time = 1000.0;
        int optimal_cutoff = 0;
        // Let's test different cutoff for this optimization technique.
        for (int cutoff = 2; cutoff < data_size/4;++cutoff) {
            // Start process.
            QuickSortOptimization optimization = new QuickSortOptimization(cutoff);
            long start = System.nanoTime();
            optimization.quickSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();
            time = (end - start) / DIV_FACTOR;
            System.out.println("Time of cutoff = " + cutoff + " = "+time+" sec");
            if(time < minimum_time)
            {
                minimum_time = time;
                optimal_cutoff = cutoff;
            }
        }
        System.out.println("The best cutoff = " + optimal_cutoff + " with time = "+minimum_time+" sec");
    }

    // Function to tracing the example 1 in slide# 14 to slide 19.
    public static void test_QuickSort()
    {
        int[] arr = { 4, 58,  8, 15, 24, 22,11,69,45,14,6,35,55,51,14,4};
        QuickSort sort = new QuickSort(true);
        sort.quickSort(arr, 0, arr.length-1);
    }

    public static void main(String args[])
    {
//        test_QuickSort_Optimization(1000);
        test_QuickSort();
    }
}
