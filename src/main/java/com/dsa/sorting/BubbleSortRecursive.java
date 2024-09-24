package com.dsa.sorting;

import java.util.Arrays;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int[] arr  = {5,4,3,2,1};
        //sorting 
        bubbleSort(arr,arr.length);

        System.out.println(Arrays.toString(arr));
    }   

    public static void bubbleSort(int[] arr,int n){
        if(n==1){
            return;
        }

        for(int i = 0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSort(arr, n-1);
    }

}
