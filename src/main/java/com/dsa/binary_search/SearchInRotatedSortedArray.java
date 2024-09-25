package com.dsa.binary_search;

/*

*Search in Rotated Sorted Array* 

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

 
 */

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		
		int[] nums = {1,3};
		int target = 0;
		System.out.println(search(nums, target));
	}
	
	 public static int search(int[] nums, int target) {
		 int n = nums.length;
		 int pivot = findPivotIndex(nums, n);
		 
		 if (pivot == -1) {
	            // just do normal binary search
	            return binarySearch(nums, target, 0 , nums.length - 1);
	        }

	        // if pivot is found, you have found 2 asc sorted arrays
	        if (nums[pivot] == target) {
	            return pivot;
	        }

	        if (target >= nums[0]) {
	            return binarySearch(nums, target, 0, pivot - 1);
	        }

	        return binarySearch(nums, target, pivot + 1, nums.length - 1);
	 }
	 
	 private static int binarySearch(int[] nums, int target, int l, int r) {
		 
		 while(l<=r) {
			 int m = l + (r-l)/2;
			 
			 if(nums[m] == target) return m;
			 else {
				 if(nums[m] > target) {
					 r = m-1;
				 }else {
					 l = m+1;
				 }
			 }
		 }
		 
		 return -1;
	 }
	 
	 private static int findPivotIndex(int[] nums, int n) {
		 
		 
		 
		 int left = 0;
		 int right = n-1;
		 int pivotIndex = -1;
		 
		 while(left<=right) {
			 
			 int mid = left + (right-left)/2;
			 
			 if(mid+1 < n && nums[mid] > nums[mid+1]) {
				 pivotIndex = mid;
				 break;
			 }else {
				 if(nums[mid] == nums[left]) {
					 left++;
				 }
				 if(mid+1 < n && nums[mid] < nums[mid+1]) {
					 left = mid+1;
				 }else {
					 right = mid;
				 }
			 }
			 
		 }
		 
		 if(pivotIndex == -1) {
			 if( nums.length>=2 && nums[0]>nums[1]) {
				 pivotIndex = 0;
			 }
		 }
		 
		 return pivotIndex;
		 
	 }

}
