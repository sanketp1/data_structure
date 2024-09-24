package com.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {12,5,0,-4,-2,1,-1,0,1};

        //sorting 
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high) {

            if(low<high){

                int pIndex = partition(arr, low, high);

                quickSort(arr, low, pIndex-1);
                quickSort(arr, pIndex+1, high);
            }
            
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

       while(i<j){
            
            while(i <= high && arr[i] <= pivot){
                i++;
            }

            while(j >= low && arr[j] > pivot){
                j--;
            }

            if(i<j){
                swap(arr,i,j);
            }
       }

        swap(arr, low, j);
        
        return j;
    }

   

    public static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

}
