package com.dsa.arrays_problems;

import java.util.Arrays;

/*

*Product of Array Except Self*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


 */


public class ProductOfAllExceptSelf {
	
	public static void main(String[] args) {
		
		//TESTCASE 1
		int[] nums1 = {1,2,3,4};
		
		//TESTCASE2
		int[] nums2 = {-1,1,0,-3,3};
		
		//OUPUT1
		System.out.println(Arrays.toString(productExceptSelf(nums1)));
		
		//OUTPUT2
		System.out.println(Arrays.toString(productExceptSelf(nums2)));
		
	}
	
	 public static int[] productExceptSelf(int[] nums) {
	      
		 int n = nums.length;
		 int[] result = new int[n];
		 
		 int leftProduct = 1;
		 int rightProduct = 1;
		 
		 //calculating left product
		 for(int i =0; i<n; i++) {
			 result[i] = leftProduct;
			 leftProduct = leftProduct * nums[i];
		 }
		 
		 //calculating right product
		 for(int j = n-1; j>=0; j--) {
			 result[j] = result[j]*rightProduct;
			 rightProduct = rightProduct * nums[j];
		 }
		 
		 
		 
		 
		 return result;
		 
		 
			 
	        
	 }
	 
	 
	
}
