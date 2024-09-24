package com.dsa;

public class BinarySearch {

    public static void main(String[] args) {

        //sorted array
        int[] arr = {2,4,6,7,8,9,10,11};
        int target = 9;

        int result = binarySearch(arr, target);

        System.out.println(target+" found at index of "+result);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; 
            }else {
                if (arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        //incase if target element is not found 
        return -1;

    }
}
