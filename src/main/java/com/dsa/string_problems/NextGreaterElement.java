package com.dsa.string_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {


    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] result = nextGreaterElementOptimze(nums1,nums2);
        System.out.println(Arrays.toString(result));
    }

    //not optimze
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //length of num1
        int n1 = nums1.length;
        int n2 = nums2.length;

        for(int i = 0; i<n1; i++){
            int found = -1;
            for(int j = 0; j<n2; j++){
                if(nums1[i]  == nums2[j]){
                    j = j+1;
                    while(j<n2){
                        if(nums1[i] < nums2[j]){
                            found = nums2[j];
                            break;
                        }
                        j++;
                    }
                }
            }
            nums1[i] = found;
        }

        return nums1;
    }

    //optimze
    public static int[]  nextGreaterElementOptimze(int[] nums1, int[] nums2){

        int n1 = nums1.length;
        int n2 = nums2.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<n2; i++){
            map.put(nums2[i], i);
        }

        for (int i = 0; i < n1; i++) {
            int found = -1;
            int curr = nums1[i];
            if(map.containsKey(curr)){
                int j = map.get(curr);
                while(j<n2){
                    if(nums2[j] > curr){
                        found = nums2[j];
                        break;
                    }
                    j++;
                }
            }

            nums1[i] = found;
        }

        return nums1;
    }

}
