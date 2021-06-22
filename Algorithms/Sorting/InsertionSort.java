package Algorithms.Sorting;

import java.io.*;
import java.util.*;

public class InsertionSort {
    static public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) throws IOException {
        int arr[] = { 5, 9, 0, 1, 8, 3 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
