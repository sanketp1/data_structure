package com.dsa.dynamic_programming;

import java.util.*;
public class CanSum{

    public static void main(String[] args){

        int[] nums = {7,14};
        int targetSum = 300;
        Map<Integer,Boolean> map = new HashMap<>();
        boolean result = canSum(nums, targetSum ,map);

        System.out.println(result);

    }

    public static boolean canSum(int[] nums, int targetSum, Map<Integer,Boolean> memo){

        if(memo.containsKey(targetSum)) return true;

        if(targetSum==0) return true;

        if(targetSum<0) return false;


        for(int num : nums){
            int remainder = targetSum - num;

            if(canSum(nums,remainder,memo)){
                memo.put(remainder, true);
                return memo.get(remainder);
            }
        }

        return false;

    }

}