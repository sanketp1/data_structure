package com.dsa.sliding_window;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {

        int max = 0;
        int n = nums.length;
        int l=0,r=0;

        while(r < n)
        {
            if(nums[r] == 0) {
                k--;
            }
            if(k < 0)
            {
                if(nums[l]==0)
                    k++;
                l++;
            }
            if(k>=0)
                max = Math.max(max,r-l+1);
            r++;
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }



}
