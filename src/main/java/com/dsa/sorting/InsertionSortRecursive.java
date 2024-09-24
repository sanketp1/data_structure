package com.dsa.sorting;

import java.util.Arrays;

public class InsertionSortRecursive {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        //sorting
        insertionSort(arr,0,arr.length);

        System.out.println(Arrays.toString(arr));    
    }

    public static void insertionSort(int[] arr, int i,  int n){
       
       if(i>n-1){
            return;
       }
       int key = arr[i];
       int j = i-1;

       while(j>=0 && arr[j]>key){
            arr[j+1] = arr[j];
            j--;
       }
       arr[j+1] = key;

       insertionSort(arr, i+1, n);       
    }
    
}
