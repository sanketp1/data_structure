package com.dsa.dynamic_programming;

public class CountOfSubsetSum {
    private static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        int[] nums = {0,1,3};
        int target = 4;
//        System.out.println("Count of subsets: " + countSubsetsTabulation(nums, target));
        Integer[][] dp = new Integer[nums.length+1][target+1];
        System.out.println(solveTab(nums,target));
    }


    private static int solveRecur(int[] nums, int target, int i, Integer[][] dp){
        if(target == 0) return 1;
        if(dp[i][target] != null) return dp[i][target];
        if(i>= nums.length) return 0;


        if(target >= nums[i]){
            return dp[i][target] =  solveRecur(nums, target-nums[i], i+1, dp) + solveRecur(nums,target,i+1, dp);
        }else{
            return dp[i][target] =  solveRecur(nums,target,i+1, dp);
        }
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
                    dp[i][j] = ((dp[i - 1][j - nums[i - 1]])%MOD) + ((dp[i - 1][j]) %MOD);
                } else {
                    // Exclude the current element
                    dp[i][j] = (dp[i - 1][j])%MOD;
                }
            }
        }

        // Return the count of subsets that sum to the target using all elements
        return dp[n][target]%MOD;

    }





    public static int countSubsets(int[] nums, int tar) {
        int n = nums.length;
        int[][] dp = new int[n + 1][tar + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(nums, tar, n, dp);
    }



    private static int solve(int[] nums, int tar, int n, int[][] dp) {
        // Base cases
        if (tar == 0) return 1; // A subset with sum 0 always exists (empty subset)
        if (n == 0) return 0; // No subsets possible if no elements are left

        // Check memoized result
        if (dp[n][tar] != -1) return dp[n][tar];

        // Recursive calls
        if (nums[n - 1] <= tar) {
            dp[n][tar] = solve(nums, tar - nums[n - 1], n - 1, dp) + solve(nums, tar, n - 1, dp);
        } else {
            dp[n][tar] = solve(nums, tar, n - 1, dp);
        }

        return dp[n][tar];
    }


    public static int countSubsetsTabulation(int[] nums, int tar) {
        int n = nums.length;
        int[][] dp = new int[n + 1][tar + 1];

        // Base cases: When target is 0, there's always one subset (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= tar; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][tar];
    }


}
