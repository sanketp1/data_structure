package com.dsa.arrays_problems;

import java.util.*;

public class MoveAllNegativeToOneSide {

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        segregateElements(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void segregateElements(int[] arr) {
        // Your code goes here
        // elements respectively
        Stack<Integer> neg = new Stack<>();
        Stack<Integer> pos = new Stack<>();
        for (int value : arr) {
            if (value < 0)
                neg.push(value);
            else
                pos.push(value);
        }

        // Place the elements back to original array arr[]
        for (int i = arr.length - 1; i >= 0; i--) {

            // first place the negative elements
            if (!neg.isEmpty()) {
                arr[i] = neg.pop();
            }

            // If negative elements were all placed
            // then place remaining elements
            else {
                arr[i] = pos.pop();
            }
        }
    }

    private static void swap(int[] arr, int f, int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

}
