package com.dsa.arrays_problems;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target);
        System.out.println(ans);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n <= 3){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Set<String> seen = new HashSet<>();

        for(int i = 0; i<n-1; i++){
            int a = nums[i];
            int b = nums[i+1];
            int newTarget = target - (a+b);
            Map<Integer,Integer> map = new HashMap<>();

            for(int j = 0; j<n; j++){
                int req = newTarget - nums[j];
                if( j!= i && j!=i+1 && map.containsKey(req) && map.get(req) != i && map.get(req) != i+1){
                    int[] arr = {a,b,nums[j],req};
                    Arrays.sort(arr);
                    String key = arr[0]+","+arr[1]+","+arr[2]+","+arr[3];
                    if(!seen.contains(key)) {
                        seen.add(key);
                        result.add(new ArrayList<>(Arrays.asList(arr[0], arr[1], arr[2], arr[3])));
                    }
                }
                map.put(nums[j], j);
            }

        }

//        [[-3,-2,2,3],[-2,-1,1,2],[-2,-1,0,3],[-1,0,0,1],[-2,0,0,2],[-3,0,0,3],[-3,0,1,2]]
//        [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        return result;
    }
}
