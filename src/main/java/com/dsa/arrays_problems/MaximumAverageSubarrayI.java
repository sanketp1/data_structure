package com.dsa.arrays_problems;

import java.util.Arrays;

/*
 
 *Maximum Average Subarray I*
 
 You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 
 
 */

public class MaximumAverageSubarrayI {
		
		public static void main(String[] args) {
			
			int[] nums = {1,12,-5,-6,50,3}; 
			int k = 4;
			
			double result = findMaxAverage(nums, k);
			
			System.out.println(result); //expected : 12.75000
			
			int[] nums1 = {5};
			int k1 = 1;
			
			double result1 = findMaxAverage(nums1, k1);
			
			System.out.println(result1);
		}
	
	   public static double findMaxAverage(int[] nums, int k) {
	       
		   //length of array
		   int n = nums.length;
		   
		   //making prefix sum
		   for(int i = 1; i<n; i++) {
			   nums[i] = nums[i-1]+nums[i];
		   }
		   
		   int p1 = -1;
		   int p2 = k-1;
		   
		   double maxAvg = Integer.MIN_VALUE;
		   
		   while(p2<n) {
			   double avg = (double) (nums[p2]- (p1 == -1 ? 0 :nums[p1]) )/k;
			   maxAvg = Math.max(maxAvg, avg);
			   p2++;
			   p1++;
			   
		   }
		   
		   
		   return maxAvg;
		   
	   }

}
