package com.dsa.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
 *Construct String with Minimum Cost*
 
 You are given a string target, an array of strings words, and an integer array costs, both arrays of the same length.
 Imagine an empty string s.
	
	You can perform the following operation any number of times (including zero):
	
	Choose an index i in the range [0, words.length - 1].
	Append words[i] to s.
	The cost of operation is costs[i].
	Return the minimum cost to make s equal to target. If it's not possible, return -1.
	
	 
	
	Example 1:
	
	Input: target = "abcdef", words = ["abdef","abc","d","def","ef"], costs = [100,1,1,10,5]
	
	Output: 7
	
	Explanation:
	
	The minimum cost can be achieved by performing the following operations:
	
	Select index 1 and append "abc" to s at a cost of 1, resulting in s = "abc".
	Select index 2 and append "d" to s at a cost of 1, resulting in s = "abcd".
	Select index 4 and append "ef" to s at a cost of 5, resulting in s = "abcdef".
	Example 2:
	
	Input: target = "aaaa", words = ["z","zz","zzz"], costs = [1,10,100]
	
	Output: -1
	
	Explanation:
	
	It is impossible to make s equal to target, so we return -1.
	
	 
	
	Constraints:
	
	1 <= target.length <= 5 * 104
	1 <= words.length == costs.length <= 5 * 104
	1 <= words[i].length <= target.length
	The total sum of words[i].length is less than or equal to 5 * 104.
	target and words[i] consist only of lowercase English letters.
	1 <= costs[i] <= 104

 */
public class MinimumCost {
//	static int minCost = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		//TESTCASE 1
		String target = "abcdef";
		String[] words = {"abdef","abc","d","def","ef"};
		int[] costs = {100,1,1,10,5};
		
		int result = minimumCost(target, words, costs);
		System.out.println(result);
		
//		System.exit(0);
		
		//TESTCASE 2
		String target1 = "aaaa"; 
		String[] words1 = {"z","zz","zzz"}; 
		int[] costs1 = {1,10,100};
		
		int result1 = minimumCost(target1, words1, costs1);
		System.out.println(result1);
		
		//TESTCASE 3
		String target2 = "wvgafw";
		String[] words2 = {"wvgafw","w"};
		int[] costs2 = {1,2};
		
		int result2 = minimumCost(target2, words2, costs2);
		
		System.out.println(result2);
	}
	
	 public static int minimumCost(String target, String[] words, int[] costs) {
		 	//putting map for memoization
		 	Map<String,Integer> map = new HashMap<>();
	        int result =  helper(target, words, costs,map, Integer.MAX_VALUE);
	        return result == Integer.MAX_VALUE ? -1 : result;
	 }
	 
   public static int helper(String target, String[] words, int[] costs,  Map<String,Integer> map, int minCost){
        
	   if(map.containsKey(target)) return map.get(target);
       
	   if(target.isEmpty()) return 0;
        
        

        for(int i = 0; i<words.length; i++) {
        	if(target.startsWith(words[i])) {
        		String remain = target.substring(words[i].length());
        		int c = helper(remain, words, costs,map,minCost) + costs[i];
        		minCost = Math.min(minCost, c);
        	}
        }
        
        map.put(target, minCost);
    
     return minCost;

    }

}
