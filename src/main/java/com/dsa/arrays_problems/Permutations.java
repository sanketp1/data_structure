package com.dsa.arrays_problems;
import java.util.*;

public class Permutations {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = permute(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i+1)+"-->"+result.get(i));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        solve(nums,result, new ArrayList<>(), new HashSet<>());

        return result;
    }

    private static void solve(int[] nums, List<List<Integer>> result, List<Integer> temp,  Set<Integer> set){

        if(set.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(Integer x : nums){
            if(!set.contains(x)){
                set.add(x);
                temp.add(x);
                solve(nums, result, temp, set);
                //backtracking
                set.remove(x);
                temp.remove(temp.size()-1);
            }

        }

    }



}
