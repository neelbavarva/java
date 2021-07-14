package Java.Algorithms.Searching;

import java.io.*;
import java.util.*;

public class BinarySearch {

    static public int binarySearchIterative(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == target) {
                return middle;
            }

            if (target < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    static public int binarySearchRecursive(int arr[], int target, int left, int right) {

        if (right < left) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (target < arr[middle]) {
            return binarySearchRecursive(arr, target, left, middle - 1);
        } else {
            return binarySearchRecursive(arr, target, middle + 1, right);
        }
    }

    public static void main(String[] args) throws IOException {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int x = binarySearchIterative(arr, 5);
        System.out.println(x);
    }
}
