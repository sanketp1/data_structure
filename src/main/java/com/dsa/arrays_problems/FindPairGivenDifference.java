package com.dsa.arrays_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindPairGivenDifference {

    public static void main(String[] args) {
        int[] arr = {6,3,5,7,2,3,3,8,2,4};
        int x = 2;
//        boolean result = findPair(arr,x);
        int counts = findPairs(arr,x);
        System.out.println(counts);
    }


    public static boolean findPair(int[] arr, int x) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num + x) || set.contains(num - x)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // Difference can't be negative

        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        // Populate the frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check for pairs
        for (int num : freqMap.keySet()) {
            if (k == 0) {
                // Special case for k = 0, look for duplicates
                if (freqMap.get(num) > 1) {
                    count++;
                }
            } else {
                // Check for num + k existence
                if (freqMap.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}