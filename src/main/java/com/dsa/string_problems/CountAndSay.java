package com.dsa.string_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

 *Count And Say*

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.

 

Example 1:

Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
Example 2:

Input: n = 1

Output: "1"

Explanation:

This is the base case.

 

Constraints:

1 <= n <= 30
 
 */

public class CountAndSay {
	
	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
	
    public static String countAndSay(int n) {
        
    	//recursive
//        return f(n);
    	
    	//iterative
    	return fn(n);
    }
    
    //recursive approach

    private static String f(int n){

        if(n==1) return "1";
        
        String prev = f(n-1);
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for(char c : prev.toCharArray()) {
        	if(map.containsKey(c)) {
        		map.put(c, map.get(c)+1);
        	}else {
        		map.put(c, 1);
        	}
        }
        
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
        	ans.append(e.getValue());
        	ans.append(e.getKey());
        }
        
        return ans.toString();
    }
    
    //iterative approach
    public static String fn(int n) {	
    	String base = "1";
    	int i = 1;
    	int x = 0;
		int y = 0;
    	while(i<n) {
    		StringBuilder temp = new StringBuilder();
    		
    		while( y<base.length() && base.charAt(x) == base.charAt(y)) {
    			y++;
    		}
    		
    		int countRange = y-x +1;
    		temp.append(countRange);
    		temp.append(base.charAt(x));
    		x = y+1;
    		y++;
    		i++;
    	}
    	
    	
//    	for(int i =2; i<=n; i++) {
//    		Map<Character,Integer> map = new HashMap<>();
//    		for(char c : dp[i-1].toCharArray()) {
//    			if(map.containsKey(c)) {
//            		map.put(c, map.get(c)+1);
//            	}else {
//            		map.put(c, 1);
//            	}
//    		}
//    		StringBuilder temp = new StringBuilder();
//    		
//    		Set<Character> set = map.keySet();
//    		List<Character> keySet = new ArrayList<>(set);
//
//    		
//    		for(int x=keySet.size()-1; x>=0; x--) {
//    			temp.append(map.get(keySet.get(x)));
//    			temp.append(keySet.get(x));
//    		}
//    		
//    		
//    		
//
//    		
//    		dp[i] = temp.toString();
//    	}
    	
    	
    	return base;
 
    	
    }
    
	

}
