package com.dsa.arrays_problems;

public class ReversePairs {

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        int result = reversePairs(nums);
        System.out.println(result);
    }

    public static int reversePairs(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n-1);
    }

    private static int helper(int[] nums, int left, int right){
        int inv = 0;

        if(left < right){
            int mid = left + (right-left)/2;

            //processing left of the subtree
            inv+=helper(nums,left,mid);

            //processing right of the subtree
            inv+=helper(nums,mid+1,right);

            inv+=merge(nums,left,mid,right);

        }

        return inv;
    }

    private static int merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right-left+1];

        int i = left;
        int j = mid+1;
        int k = 0;
        int inv = 0;

        while(i<=mid && j<=right){
            if((long) nums[i] > 2 * (long) nums[j]){
                inv+=(mid-i+1);
                j++;
            }
            else{
                i++;
            }
        }

        //resetting the pointers
        i = left;
        j = mid+1;

        while(i<=mid && j<=right){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[k++] = nums[i++];
        }

        while(j<=right){
            temp[k++] = nums[j++];
        }

        int y = 0;
        for(int x  = left; x <= right; x++){
            nums[x] = temp[y++];
        }

        return inv;
    }

}
