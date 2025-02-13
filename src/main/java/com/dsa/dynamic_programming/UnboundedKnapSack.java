package com.dsa.dynamic_programming;
import java.util.*;

public class UnboundedKnapSack {

    public static void main(String[] args) {
        int n = 3;
        int w = 10;
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};

        int result = unboundedKnapsack(n, w, profit, weight);
        System.out.println(result);

    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

//        Map<Integer,Integer> dp = new HashMap<>();

        return solve(n, w, profit, weight);
    }

    //tabulation
    private static int solve(int n, int w, int[] profit, int[] weight){
        int[][] dp = new int[n+1][w+1];

        for(int i = 1; i<=n; i++){
            for (int j = 1; j <=w; j++) {
                if(j >= weight[i-1]){
                    dp[i][j] = Math.max(profit[i-1] + dp[i][j-weight[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }

        return dp[n][w];
    }

    //memoization
    private static int solve(int n, int w, int[] profit, int[] weight, Map<Integer,Integer> dp){
        if(n<=0){
            return 0;
        }

        if(dp.containsKey(w)){
            return dp.get(w);
        }

        if(w >= weight[n-1]){
            int result =  Math.max( (profit[n-1] + solve(n, w-weight[n-1], profit, weight, dp)),
                    solve(n-1,w,profit,weight, dp)
            );
            dp.put(w, result);

            return result;

        }else{
            int result =  solve(n-1, w, profit, weight, dp);
            dp.put(w, result);
            return result;
        }
    }

}
