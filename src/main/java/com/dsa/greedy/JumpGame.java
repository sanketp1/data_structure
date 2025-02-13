package com.dsa.greedy;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};

        System.out.println(canJump(nums));
        System.out.println(jumps(nums));
    }

    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                // If we can't reach the current index, return false
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            // If we can reach or exceed the last index, return true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static int jumps(int[] nums) {
        int jumps = 0;       // Count of jumps
        int farthest = 0;    // Farthest index reachable
        int currentEnd = 0;  // End of the current range we can reach

        for (int i = 0; i < nums.length - 1; i++) { // Exclude the last index
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest we can go

            if (i == currentEnd) {  // If we've reached the end of the current range
                jumps++;            // Increment jump count
                currentEnd = farthest; // Update the current range to the farthest point

                if (currentEnd >= nums.length - 1) { // If we can reach the end, break
                    break;
                }
            }
        }

        return jumps;
    }



}
