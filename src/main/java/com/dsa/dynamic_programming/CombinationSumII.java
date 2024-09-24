package com.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  
  *Combination Sum II*
  
  Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

	Each number in candidates may only be used once in the combination.
	
	Note: The solution set must not contain duplicate combinations.
	
	 
	
	Example 1:
	
	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output: 
	[
	[1,1,6],
	[1,2,5],
	[1,7],
	[2,6]
	]
	Example 2:
	
	Input: candidates = [2,5,2,1,2], target = 5
	Output: 
	[
	[1,2,2],
	[5]
	]
	 
	
	Constraints:
	
	1 <= candidates.length <= 100
	1 <= candidates[i] <= 50
	1 <= target <= 30

 */
public class CombinationSumII {
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5}; 
		int target = 8;
		
		System.out.println(combinationSum2(candidates, target));
	}
	
	 public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	     
		 if(target == 0) return new ArrayList(Arrays.asList(new ArrayList<>()));
		 
		 if(target < 0) return null;
		 
		 List<List<Integer>> result = new ArrayList<>();
		 
		 for(int n: candidates) {
			 if(target>n) {
				 int remainder = target-n;
				 
				 List<List<Integer>> ways = combinationSum2(candidates, remainder);
				 List<List<Integer>> targetWays = new ArrayList<>();
				 
				 if(ways!=null) {
					 for(List<Integer> way : ways) {
						 List<Integer> subList = new ArrayList<>();
						 subList.add(n);
						 subList.addAll(way);
						 targetWays.add(subList);
					 }
					 
					 result.addAll(result);
				 }
				 
				 
			 }
		 }
		 
		 return result;
		 
	 }

}
