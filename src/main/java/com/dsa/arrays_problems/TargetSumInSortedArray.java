package com.dsa.arrays_problems;


import java.util.ArrayList;
import java.util.List;

public class TargetSumInSortedArray {

     static class Pair {
         int j;
         int i;

        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        static  Pair empty = new Pair(-1,-1);

        @Override
        public String toString() {
            return "Pair("+i+", "+j+")";
        }
    }

    public static void main(String[] args) {
         int[] nums =    {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31};

         int target = 28;

         Pair result = targetSum(nums,target);

         List<Pair> results = findAllPairOfTargetSum(nums,target);

        System.out.println("First Pair = "+result);
        System.out.println("All Possible Pair = "+results);

    }
    public static Pair targetSum(int[] nums, int target){

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int sum = nums[start]+nums[end];

            if(sum == target){
                return new Pair(start,end);
            }

            if(sum>target){
                end--;
            }else{
                start++;
            }

        }

        return Pair.empty;
    }

    public static List<Pair> findAllPairOfTargetSum(int[] nums, int target){
        List<Pair> result = new ArrayList<>();
        int start = 0;
        int end = nums.length-1;

        while(start<end) {
            int sum = nums[start] + nums[end];

            if (sum == target) {
                result.add(new Pair(start, end));
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }


}
