package com.dsa.arrays_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RearrangeElements {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2));
        System.out.println(arr);
        
        rearrange(arr);
        System.out.println(arr);

    }

    static void rearrange(ArrayList<Integer> arr) {
        // code here
        List<Integer> p = new ArrayList<>();
        List<Integer> n = new ArrayList<>();

        for(int x : arr){
            if(x >= 0){
                p.add(x);
            }else{
                n.add(x);
            }
        }

        int l1 = p.size();
        int l2 = n.size();

        int i = 0;
        int j = 0;
        int idx = 0;
        while(i<l1 && j<l2){
            arr.set(idx++,p.get(i));
            arr.set(idx++,n.get(j));
            i++;
            j++;
        }

        //for remaining
        while(i<l1){
            arr.set(idx++,p.get(i++));
        }

        while(j<l2){
            arr.set(idx++,n.get(j++)); 
        }

      
    }


    static void rearrange2(ArrayList<Integer> arr) {
       boolean flag = true;
       // code here
       for (int i = 0; i < arr.size(); i++) {
            int reqIdx = i;
            if(flag){
                while(arr.get(reqIdx)<0){
                    reqIdx++;
                }
                int temp = arr.get(i);
                arr.set(i, arr.get(reqIdx));
                arr.add(reqIdx,temp);
            }else{
                while (arr.get(reqIdx)>=0) {
                    reqIdx++;
                }
            }
       }
      
    }

}
