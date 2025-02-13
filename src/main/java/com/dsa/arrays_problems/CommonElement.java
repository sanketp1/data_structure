package com.dsa.arrays_problems;

import java.util.*;

public class CommonElement {

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 1, 1, 2, 2, 2);
        List<Integer> arr2 = Arrays.asList(1, 1, 2, 2, 2);
        List<Integer> arr3 = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2);

        List<Integer> result = commonElements(arr1, arr2, arr3);

        System.out.println(result);
    }

    public static List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here

        List<Integer> result = new ArrayList<>();

       Set<Integer> s1 = new HashSet<>(arr1);
       Set<Integer> s2 = new HashSet<>(arr2);
       Set<Integer> s3 = new HashSet<>(arr3);

       List<Integer> unq = new ArrayList<>(s1);
       int i = 0;

       while(i<unq.size()){
           int curr = unq.get(i);
           if(s1.contains(curr) && s2.contains(curr) && s3.contains(curr)){
               result.add(curr);
           }
           i++;
       }




        return result;
    }

}
