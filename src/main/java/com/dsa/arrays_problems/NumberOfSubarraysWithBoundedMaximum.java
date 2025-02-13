package com.dsa.arrays_problems;

public class NumberOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        int[] nums = {73,55,36,5,55,14,9,7,72,52};
        int left = 32;
        int right = 69;
        int result = numSubarrayBoundedMax(nums, left, right);
        System.out.println(result);
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarrays(nums, right) - countSubarrays(nums, left - 1);
    }

    private static int countSubarrays(int[] nums, int bound) {
        int count = 0, curr = 0;
        for (int num : nums) {
            if (num <= bound) {
                curr++;
                count += curr;
            } else {
                curr = 0;
            }
        }
        return count;
    }


}
