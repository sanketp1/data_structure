package com.dsa.hash_map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 
*Longest Consecutive Sequence*

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

 
 
 */

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
	
		int[] nums = {100,4,200,1,3,2};
		 List<Integer> temp = new ArrayList<>();
		 
		System.out.println(longestConsecutive(nums));
	}
	
	public static int longestConsecutive(int[] nums) {
		
		 Set<Integer> set = new HashSet<>();
	        for (int num : nums) {
	            set.add(num);
	        }

	        int longest = 0;

	        for (int num : set) {
	            if (!set.contains(num - 1)) {
	                int length = 1;
	                int nextNum = num + 1;
	                while (set.contains(nextNum)) {
	                    length++;
	                    nextNum++;
	                }
	                longest = Math.max(longest, length);
	            }
	        }

	        return longest;
		
	}

}
