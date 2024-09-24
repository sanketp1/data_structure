package com.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};

        //sorting 
        selectionSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
        
    }

    public static void selectionSort(int[] arr, int n){

        for(int i =0; i<n; i++){
            int maxEleIdx = getMaxEleIndex(arr, n-i);
            swap(arr,maxEleIdx, n-i-1);
        }
        
    }

    public static void swap(int[] arr, int f, int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    public static int getMaxEleIndex(int[] arr, int end){
        int mxEleIdx = 0;

        for (int i = 0; i < end; i++) {
            if(arr[i]>arr[mxEleIdx]){
                mxEleIdx = i;
            }
        }

        return mxEleIdx;
    }
}
