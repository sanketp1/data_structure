package com.dsa.arrays_problems;

import java.util.Arrays;

//problem link:- https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};
        mergeArrays(a,b);
        System.out.println(Arrays.toString(a)+" "+Arrays.toString(b));
    }

    // Function to merge the arrays.
    public static void mergeArrays(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        int[] result = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                result[k++] = a[i++];
            }else{
                result[k++] = b[j++];
            }
        }

        while(i<n1){
            result[k++] = a[i++];
        }

        while(j<n2){
            result[k++] = b[j++];
        }

        for(int x = 0; x<result.length; x++){
            if(x<n1){
                a[x] = result[x];
            }else{
                b[x-n1] = result[x];
            }
        }

    }
}
