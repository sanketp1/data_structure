package com.dsa.dynamic_programming;
import java.util.*;

public class TargetSum {

    private static int MOD = 100_000_007;

    public static void main(String[] args) {
        int[] nums = {7,9,3,8,0,2,4,8,3,9};
        int target = 0;

        System.out.println(findTargetSumWays(nums,target));

    }

    public static int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        int sum = Arrays.stream(nums).reduce(0, Integer::sum);

        int newTarget = (target + sum)/2;



        return solveTab(nums,newTarget);
    }

    private static int solveTab(int[] nums, int target){
        int n = nums.length;

        // Create DP table: dp[i][j] represents the count of subsets using first i elements to sum up to j
        int[][] dp = new int[n + 1][target + 1];

        // Base case: There's always one subset (empty subset) that sums to 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    // Include the current element or exclude it
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the count of subsets that sum to the target using all elements
        return dp[n][target];

    }

}
