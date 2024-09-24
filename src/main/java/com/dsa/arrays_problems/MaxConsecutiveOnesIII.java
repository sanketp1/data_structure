package com.dsa.arrays_problems;

/*

  *Max Consecutive Ones III*
  
  Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length



 */

public class MaxConsecutiveOnesIII {
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0}; 
		int k = 2;
		
		System.out.println(longestOnes(nums, k));
//		
		int[] nums1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k1 = 3;
		
		System.out.println(longestOnes(nums1, k1));
	}
	
    public static int longestOnes(int[] nums, int k) {
        
    	//length of array
    	int n = nums.length;
    	
    	int count = 0;
    	int j =0;
    	int longSeq = 0;
    	
    	for(int i = 0; i<n; i++) {
    		if(nums[i] == 0) {
    			count++;
    		}
    		
    		while(count>k) {
        		if(nums[j] == 0) {
        			count--;
        		}
        		j++;
        	}
    		
    		longSeq = Math.max(longSeq, i-j+1);
    	}
    	
    	return longSeq;
    	
    	
    	

    	
    	
    }
	
}
