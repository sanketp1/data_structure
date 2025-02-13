package com.dsa.dynamic_programming;

//problem link:- https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubSetSumDifference {

    public static void main(String[] args) {
        int[] nums = {76,8,45,20,74,84,28,1};
        System.out.println(minimumDifference(nums));
    }

    public static int minimumDifference(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;

        //suppose if array contains -Ve number then then shifting element by adding minimum to each number in the array
        int min = Arrays.stream(nums).min().orElse(0);


        if(min<0){
            //shifting each element by adding abs(min)
            int offset = Math.abs(min);
            for(int i = 0; i<n; i++){
                nums[i] = nums[i]+offset;
            }
        }

        int sum = Arrays.stream(nums).sum();
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0;  i < sum / 2; i++) {
            if (dp[i]) {
                minDiff = Math.min(minDiff, sum - 2 * i);
            }
        }
        return minDiff;
    }


    private static boolean[] solve(int[] arr, int target){
        int n = arr.length;

        boolean[][] dp = new boolean[n+1][target+1];

        for(int i = 0; i<n+1; i++){
            dp[i][0] = true;
        }

        for(int j = 1; j<target+1; j++){
            dp[0][j] = false;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<target+1; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n];
    }

}
