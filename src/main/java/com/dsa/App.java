package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	
//    	int[] arr = {-100000,-100000};
//    	String  s = "sfhsdf";
//    	
//    	
//    	System.out.println(findClosestNumber(arr));
    	
    	Set<List<Integer>> set = new HashSet<>();
    	
    	List<Integer> l1 = new ArrayList<>();
    	List<Integer> l2 = new ArrayList<>();
    	
    	l1.add(0);
    	l1.add(1);
    	
    	l2.add(1);
    	l2.add(0);
    	
    	set.add(l1);
    	set.add(l2);
    	
    	System.out.println(set);
    	
    }
    
    public static int findClosestNumber(int[] nums) {
        int close = nums[0];
        for(int n : nums){
            
            int dist = Math.abs(n-0);

            if(dist <= Math.abs(close)){
                if(Math.abs(close) == dist){
                    close = Math.max(close, n);
                }else{
                   close = n;
                }
            }
        }

        return close;
    }
    
    static int getMin(int[] arr) {
    	int min = arr[0];
    	
    	for(int n : arr) {
    		if(n<min) {
    			min = n;
    		}
    	}
    	
    	return min;
    }
    
    static int getMax(int[] arr) {
    	int max = arr[0];
    	for(int n:arr) {
    		if(n>max) {
    			max = n;
    		}
    	}
    	
    	return max;
    }
    
    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);
        
        System.out.println(Arrays.toString(happiness));
      
        int subFactor = 0;
        int end = n-1;
        long sum = 0;
        
        while(k>0){
          if(happiness[end]-subFactor>=0)
        	  sum+=happiness[end]-subFactor;
          subFactor++;
          k--;
          end--;
        }

       return sum;

      }

    public static int fact(int n){
        if(n==1) return 1;
        return n * fact(n-1);
    }

    public static int fact(int n,boolean isRecursive){

        int result = 1;
        while(n!=1){
            result *=n;
            n = n-1;
        }
        return result;
    }
}
