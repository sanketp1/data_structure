package com.dsa.dynamic_programming;

public class KnapSack {

    public static int knapSack(int[] wt, int[] val, int w, int n){
        if(n==0 || w==0) return 0;

        if(wt[n-1] <= w){
            return Math.max(val[n-1]+knapSack(wt, val, w-wt[n-1], n-1), knapSack(wt, val, w, n-1));
      }else{
        if(wt[n-1]>w) return knapSack(wt, val, w, n-1);
      }
       return knapSack(wt, val, w, n-1);
    }

    public static void main(String[] args) {
        int[] wt = {1,2,5,6};
        int[] val = {2,1,4,5};
        int w = 8;
        int n = 4;
        int max = knapSack(wt, val, w, n);

        System.out.println(max);

    }
    
}
