package com.dsa.sliding_window;

public class LongestSubarrayof1sAfterDeletingOneElement {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        //length of array
        int n = nums.length;

        int max = 0;
        int l = 0, r = 0;
        int k = 1;

        while(r<n){
            if(nums[r] == 0){
                k--;
            }

            if(k<0){
                if(nums[l] == 0){
                    k++;
                }
                l++;
            }

            if(k>=0){
                max = Math.max(max,r-l);
            }

            r++;
        }

        return max;
    }

}
