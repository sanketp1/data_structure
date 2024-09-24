package com.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        
        int[] arr = {5,4,3,2,1};

        //sorting
        bubbleSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr, int n){

        for (int i = 0; i < n; i++) {
            for(int j = 0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }

    }

    //method for swapping element
    public static void swap(int[] arr, int f, int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
    
}
