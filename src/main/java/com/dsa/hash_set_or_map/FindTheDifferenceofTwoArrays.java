package com.dsa.hash_set_or_map;
import java.util.*;
import java.util.stream.Collectors;

public class FindTheDifferenceofTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        System.out.println(findDifference(nums1,nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        for(Integer n : nums1){
            if(!s2.contains(n)){
                l1.add(n);
            }
        }

        for (Integer m : nums2){
            if(!s1.contains(m)){
                l2.add(m);
            }
        }

        result.add(l1);
        result.add(l2);

        return result;



    }
}
