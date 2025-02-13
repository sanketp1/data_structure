package com.dsa.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//problems link:- https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
/*
    Recursive Tree

    solve([1, 2, 3], 6, 3)  <-- root node
   |
   |-- solve([1, 2, 3], 3, 2)  (include 3: 6 - 3 = 3)
   |     |
   |     |-- solve([1, 2, 3], 1, 1)  (include 2: 3 - 2 = 1)
   |     |     |
   |     |     |-- solve([1, 2, 3], 0, 0)  (include 1: 1 - 1 = 0) <-- true (subset found)
   |     |     |
   |     |     |-- solve([1, 2, 3], 1, 0)  (exclude 1) <-- false
   |     |
   |     |-- solve([1, 2, 3], 3, 1)  (exclude 2)
   |           |
   |           |-- solve([1, 2, 3], 2, 0)  (include 1: 3 - 1 = 2) <-- false
   |           |
   |           |-- solve([1, 2, 3], 3, 0)  (exclude 1) <-- false
   |
   |-- solve([1, 2, 3], 6, 2)  (exclude 3)
         |
         |-- solve([1, 2, 3], 4, 1)  (include 2: 6 - 2 = 4)
         |     |
         |     |-- solve([1, 2, 3], 3, 0)  (include 1: 4 - 1 = 3) <-- false
         |     |
         |     |-- solve([1, 2, 3], 4, 0)  (exclude 1) <-- false
         |
         |-- solve([1, 2, 3], 6, 1)  (exclude 2)
               |
               |-- solve([1, 2, 3], 5, 0)  (include 1: 6 - 1 = 5) <-- false
               |
               |-- solve([1, 2, 3], 6, 0)  (exclude 1) <-- false

 */
public class SubsetSum {

    public static void main(String[] args) {
       int[] arr = {3, 34, 4, 12, 5, 2};
       int target = 9;

        System.out.println(isSubsetSum(arr,target));
    }

    public static boolean isSubsetSum(int[] arr, int target){
        if(arr == null || arr.length == 0) return false;
        return solve(arr,target);
    }

    //recursive approach
    private static boolean solve(int[] arr, int target, int n){
        if(n<=0) return false;

        if(target == 0) return true;

        if(target >= arr[n-1]){
            return solve(arr,target-arr[n-1], n-1) || solve(arr,target,n-1);
        }else{
            return solve(arr,target,n-1);
        }
    }

    //memoization approach
    private static boolean solve(int[] arr, int target, int n, Map<Integer,Boolean> map){
        if(n<=0) return false;

        if(target == 0) return true;

        if(map.containsKey(target)) return  map.get(target);

        boolean result;
        if(target >= arr[n-1]){
            result = solve(arr, target - arr[n - 1], n - 1, map) || solve(arr, target, n - 1, map);
        }else{
            result = solve(arr, target, n - 1, map);
        }
        map.put(target, result);
        return result;
    }

    private static boolean solve(int[] arr, int target){
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

        for(boolean[] row : dp){
            System.out.println(Arrays.toString(row));
        }

        return dp[n][target];
    }




}
