package com.dsa.dynamic_programming;
import java.util.*;

public class HowSum {
    
    public static void main(String[] args) {

        int[] nums = {7,14};
        int targetSum = 100000;

        Map<Integer,List<Integer>> memo = new HashMap<>();

        System.out.println(howSum(nums, targetSum,memo));
        
    }

    public static List<Integer> howSum(int[] nums,int targetSum, Map<Integer,List<Integer>> memo){
        
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum==0) return new ArrayList<>();
        if(targetSum<1) return null;

        for(int num:nums){
            int remainder = targetSum-num;
            List<Integer> remainderResult = howSum(nums,remainder,memo);

            if(remainderResult!=null){
                remainderResult.add(num);
                memo.put(targetSum,remainderResult);
                return memo.get(targetSum);
            } 
        }

        memo.put(targetSum,null);

        return null;
    }
}
