package com.dsa.arrays_problems;

import java.sql.Array;
import java.util.Arrays;

/*
 
 *Minimum Size Subarray Sum*
 
  Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 
 */

public class MinimumSizeSubarraySum {
	
	public static void main(String[] args) {
	    int[] nums = {2,3,1,2,4,3};
	    int target = 7;
	    
	    System.out.println(minSubArrayLen(target, nums));
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
        
		//length of array
		int n = nums.length;
		
		int minSize = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		while(j<n) {
			int sum = 0;
			while( j<n && sum<target) {
				sum += nums[j];
				j++;
			}
			
			if(sum >=target) {
				minSize = Math.min(minSize, j-i);
			}
			
			i = j;
			
		}
		
		return minSize == Integer.MAX_VALUE ? 0 :minSize;
    }

}
