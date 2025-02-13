package com.dsa.arrays_problems;

import java.util.Arrays;

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {

        int[] arr = {1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
            int k = 1;

            for(int i = 0; i<arr.length; i++){

                while(i< arr.length-1 && arr[i]+1 == arr[i+1]){
                    k++;
                    i++;
                }

            }

            return  k;
    }


}
