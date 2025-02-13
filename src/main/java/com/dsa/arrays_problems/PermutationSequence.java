package com.dsa.arrays_problems;

import java.util.HashSet;
import java.util.Set;

public class PermutationSequence {

    private static int curr = 0;

    public static void main(String[] args) {
        int n = 3;
        int k = 1;

        String result = getPermutation(n,k);
        System.out.println(result);
    }

    public static String getPermutation(int n, int k) {
            StringBuilder res = new StringBuilder();
            solve(n,k,res,new HashSet<>());
            return res.toString();
    }

    private static void solve(int n, int k , StringBuilder res, Set<Integer> set){
        if(res.length() == n){
            curr++;
            return;
        }

        for(int i = 1; i<=n; i++){
            if(!set.contains(i)){
                set.add(i);
                res.append(i);
                solve(n,k, res, set);
                if(curr == k){
                    break;
                }
                res.deleteCharAt(res.length()-1);
                set.remove(i);
            }
        }
    }

}
