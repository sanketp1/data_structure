package com.dsa.prefix_sum;

public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        //length of array
        int n = nums.length;

        //making prefix sum
        for(int i = 1; i<n; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        int leftSum = 0;
        int totalSum = nums[n-1];

        for(int i = 0; i<n; i++){
            if(leftSum == (totalSum-nums[i])) return i;
            leftSum = nums[i];
        }

        return  -1;
    }


}
