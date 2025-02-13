package com.dsa.dynamic_programming;
import java.util.*;

public class CutIntoSegments {


    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 2;
        int z = 2;

        int result = cutSegments(n,x,y,z);

        System.out.println(result);
    }

    public static int cutSegments(int n, int x, int y, int z) {

        if(n==0) return 0;

        //memoization approach
//        Map<Integer,Integer> map = new HashMap<>();
//        int result = solveMemo(n, x, y, z, map);
//        return Math.max(result, 0);

        //tabulation approach
        int result = solveTabu(n,x,y,z);
        return result;
    }

    private static int solveMemo(int n , int x, int y, int z, Map<Integer,Integer> map){
        if (n < 0) return Integer.MIN_VALUE; // Invalid state
        if (n == 0) return 0; // Base case: No more cuts needed

        if (map.containsKey(n)) return map.get(n); // Use cached result

        // Try all possible cuts and take the maximum
        int rod1 = 1 + solveMemo(n - x, x, y, z, map);
        int rod2 = 1 + solveMemo(n - y, x, y, z, map);
        int rod3 = 1 + solveMemo(n - z, x, y, z, map);

        // Compute the best result for this state
        int result = Math.max(rod1, Math.max(rod2, rod3));
        map.put(n, result); // Cache the result
        return result;

    }

    private static int solveTabu(int n, int x, int y, int z){
        if(n==0) return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        //base case
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if(i >= x){
                dp[i] = Math.max(dp[i],dp[i-x]+1);
            }
            if(i >= y){
                dp[i] = Math.max(dp[i],dp[i-y]+1);
            }
            if(i >= z){
                dp[i] = Math.max(dp[i],dp[i-z]+1);
            }
        }

        return Math.max(dp[n],0);

    }
}
