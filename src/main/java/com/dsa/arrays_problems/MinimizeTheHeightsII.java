package com.dsa.arrays_problems;

public class MinimizeTheHeightsII {

    public static void main(String[] args) {
        int[] arr= {3, 9, 12, 16, 20};
        int k = 3;

        System.out.println(getMinDiff(arr,k));
    }

    private static int getMinDiff(int[] arr, int k) {
        // code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length; i++){
          int inc = arr[i] + k;
          int exc = arr[i] - k;

          max = Math.max(max, Math.max(inc,exc));
          if(inc > 0 && exc > 0)
            min = Math.min(min,Math.min(inc,exc));

        }

        return max-min;
    }

}
