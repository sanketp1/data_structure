package com.dsa.hash_map;

import java.util.HashMap;
import java.util.Map;

/*

*Jewels and Stones*

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.

 */

public class JewelsAndStones {
	
	public static void main(String[] args) {
		String jewels = "z";
		String stones = "ZZ";
		
		System.out.println(numJewelsInStones(jewels, stones));
	}
	
	 public static int numJewelsInStones(String jewels, String stones) {
         
		 Map<Character,Integer> map = new HashMap<>();
		 
		 int count = 0;
		 
		 for(char c : jewels.toCharArray()) {
			 map.put(c, 0);
		 }
		 
		 for(char c : stones.toCharArray()) {
			 if(map.containsKey(c)) {
				 map.put(c, map.get(c)+1);
			 }
		 }
		 
		 
		 
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			count += e.getValue();
		}
		
		return count;
		 
		 
	 }

}
