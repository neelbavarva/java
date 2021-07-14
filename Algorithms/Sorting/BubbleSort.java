package Java.Algorithms.Sorting;

import java.io.*;
import java.util.*;

public class BubbleSort {

    static public void bubbleSort(int arr[]) {
        boolean isSorted;
        for (int i = 0; i < arr.length; i++) {
            isSorted = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int[] arr = { 4, 9, 1, 6, 2, 0 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}