package com.dsa.hash_set_or_map;
import java.util.*;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        Set<Integer> set = map.values().stream().collect(Collectors.toSet());
        return map.size() == set.size();
    }

    public static void main(String[] args) {
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }
}
