package com.dsa.string_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NextGreaterElementII {


    public static void main(String[] args) {

        int[] nums = {1,8,-1,-100,-1,222,1111111,-111111};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Expected output: [2, -1, 2]


    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int found = Integer.MIN_VALUE;
            int curr = nums[i];

            // checking forward from i+1
            for(int j = i+1; j<n; j++){
                if(curr < nums[j]){
                    found = nums[j];
                    break;
                }
            }

            //checking circularly till i-1
            if(found==Integer.MIN_VALUE){
                for(int k = 0; k<i; k++){
                    if(nums[i]<nums[k]){
                        found = nums[k];
                        break;
                    }
                }
            }

            result[i] = found == Integer.MIN_VALUE ? -1 : found;
        }

        return result;
    }

}
