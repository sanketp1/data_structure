package com.dsa.arrays_problems;
import java.util.Arrays;

public class InversionCount {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }

    public static int inversionCount(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions while merging both halves
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        // Merge the two arrays
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // All remaining elements in leftArr are greater than rightArr[j]
                swaps += (leftArr.length - i);
            }
        }

        // Copy remaining elements
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return swaps;
    }


}
