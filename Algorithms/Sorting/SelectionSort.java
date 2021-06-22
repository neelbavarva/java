package Algorithms.Sorting;

import java.io.*;
import java.util.*;

public class SelectionSort {
    static public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    static public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) throws Exception {

        int arr[] = { 4, 2, 9, 5, 8 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
