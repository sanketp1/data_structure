package com.dsa.sorting;

import  java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // int[] arr = {5,4,3,2,1};

        //sorting 
        // int[] result = mergeSort(arr);

        // System.out.println(Arrays.toString(result));

        // int[] a1 = {2,10,18,20,23};
        // int[] a2 = {4,5,6,7,8};

        // int[] result = merge(a1, a2, a1.length, a2.length);

        // System.out.println(Arrays.toString(result));

         int[] testCase = {2,5,8,12,3,6,7,10};

        iterativeMegerSort(testCase,testCase.length-1);

         System.out.println(Arrays.toString(testCase));



    }


    public static void mergeSort(int[] arr, int low, int high){
            if((high-low)<=1) return;

            int mid = (low+high)/2;
            //right
    }

    public static void  iterativeMegerSort(int[] arr, int n){
       int p,l,h,mid,i;

       for(p = 2; p<=n; p=p*2){
        for(i=0; i+p-1<n; i=i+p){
            l= i;
            h = i+p-1;
            mid = (l+h)/2;
            mergeByRef(arr, l, mid, h);
        }
       }
    }

    public static void mergeByRef(int[] arr, int low, int mid, int high){
        int res[] = new int[100];
        int i=low;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                res[k++] = arr[i];
            }else{
                res[k++] = arr[j];
            }
        }

        //remaining element in the left half
        while(i<=mid){
            res[k++] = arr[i];
        }

        //remaining element in the right half
        while(j<=high){
            res[k++] = arr[j++];
        }

        //coping element from res to arr
        for(int x = low; x<=high; x++){
            arr[x] = res[x];
        }


    }


    public static  int[] merge(int[] left, int[] right, int lSize, int rSize){
        int[] mix = new int[lSize+rSize];

        int i =0;
        int j =0;
        int k =0;

        while(i<lSize && j<rSize){
            if(left[i]<right[j]){
                mix[k++] = left[i++];
            }else{
                mix[k++] = right[j++];
            }
        }

        //for remaining element in the left side array
        while(i<lSize){
            mix[k++] = left[i++];
        }

        //for remaining element in the right side array
        while(j<rSize){
            mix[k++] = right[j++];
        }


        return mix;
    }
   
    
}
