package com.dsa.dynamic_programming;

import java.util.*;

public class BestSum {

    public static void main(String[] args){

        int[] nums = {1,2,5,25};
        int targetSum = 100;

        Map<Integer,List<Integer>> memo = new HashMap<>();
       
      

        System.out.println(howSum(nums, targetSum,memo));
        
    }

    public static List<Integer> howSum(int[] nums, int targetSum, Map<Integer, List<Integer>> memo){

        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        List<Integer> shortestList = null;

        for(int num : nums){
            int remainder = targetSum-num;
            List<Integer> remainderResult = howSum(nums, remainder,memo);
            if(remainderResult!=null){
                List<Integer> combination = new ArrayList<>(remainderResult);
                combination.add(num);
                if(shortestList == null || combination.size() < shortestList.size()){
                    shortestList = combination;
                }   
            }

        }

        memo.put(targetSum, shortestList);

    return shortestList;

    }
    
}
