package com.dsa.hash_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 
 	*Two Sum*
 
	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
	You can return the answer in any order.
	
	 
	
	Example 1:
	
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	Example 2:
	
	Input: nums = [3,2,4], target = 6
	Output: [1,2]
	Example 3:
	
	Input: nums = [3,3], target = 6
	Output: [0,1]
	 
	
	Constraints:
	
	2 <= nums.length <= 104
	-109 <= nums[i] <= 109
	-109 <= target <= 109
 
 */

public class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
	       
	       int[] ans = new int[2];

	       Map<Integer,Integer> map = new HashMap<>();

	       for(int i = 0; i<nums.length; i++){
	            map.put(nums[i],i);
	       }

	       for(int j =0; j<nums.length; j++){
	           int x = target-nums[j];
	           if(map.get(x) != j && map.containsKey(x)){
	                ans[0] = j;
	                ans[1] = map.get(x);
	                break;
	           }
	       }
	    
	        return ans;
	    }
}
