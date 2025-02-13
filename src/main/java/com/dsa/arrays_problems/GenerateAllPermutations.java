package com.dsa.arrays_problems;

import java.util.*;

public class GenerateAllPermutations {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,3};

        List<List<Integer>> result = generateAllPermutations(arr);

        System.out.println(result.size());
    }

    public static List<List<Integer>> generateAllPermutations(int[] arr) {
        if (arr == null || arr.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Sort to handle duplicates
        solve(arr, result, new ArrayList<>(), new boolean[arr.length]);

        return result;
    }

    private static void solve(int[] arr, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            temp.add(arr[i]);
            solve(arr, result, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }


}
