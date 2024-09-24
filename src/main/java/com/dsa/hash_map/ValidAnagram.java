package com.dsa.hash_map;

import java.util.HashMap;
import java.util.Map;

/*

*Valid Anagram*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


 */

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram"; 
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
	
	public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
           if(map.containsKey(c)) {
        	   map.put(c, map.get(c)+1);
           }else {
        	   map.put(c, 1);
           }
        }
        
        for(char c: t.toCharArray()) {
        	if(map.containsKey(c)) {
        		map.put(c,map.get(c)-1);
        	}
        }
        
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
        	if(e.getValue()!=0) return false;
        }
        
        return true;
    }
	

}
