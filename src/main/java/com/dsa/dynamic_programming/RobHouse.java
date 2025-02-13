package com.dsa.dynamic_programming;

import java.util.Arrays;

public class RobHouse {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        // using recursion
        // int result =  solve(nums,n-1);

        //using memoization
//        int[] dp = new int[n];
//        Arrays.fill(dp,-1);
//        int result = solveMemo(nums,n-1,dp);

        //using tabulation
        int result = solveTabu(nums);

        return result;
    }

    public static int solve(int[] nums, int i){
        if(i<0) return 0;
        if(i==0) return nums[i];

        //include
        int inc = nums[i] + solve(nums,i-2);
        //exclude
        int exc = solve(nums,i-1);

        return  Math.max(inc,exc);
    }

    public static int solveMemo(int[] nums,int i,int[] dp){
        if(i<0) return 0;
        if(i==0) return nums[i];

        if(dp[i]!=-1) return dp[i];

        int inc = nums[i] + solveMemo(nums,i-2,dp);
        int exc = solveMemo(nums,i-1,dp);

        dp[i] = Math.max(inc,exc);

        return dp[i];
    }

    public static int solveTabu(int[] nums){

        int n = nums.length;
        if (n == 0) return 0; // No houses to rob
        if (n == 1) return nums[0]; // Only one house to rob

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); // Max of robbing 1st or 2nd house

        for (int i = 2; i < n; i++) {
            int inc = nums[i] + dp[i - 2]; // Include current house
            int exc = dp[i - 1]; // Exclude current house
            dp[i] = Math.max(inc, exc); // Take the maximum
        }

        return dp[n - 1];
    }

}
