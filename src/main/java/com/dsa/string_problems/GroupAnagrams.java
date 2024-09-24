package com.dsa.string_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 *Group Anagrams*

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 
 */

public class GroupAnagrams {
	
	public static void main(String[] args) {
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println(groupAnagrams(strs));
		
	}
	
	  public static List<List<String>> groupAnagrams(String[] strs) {
		  
	        List<List<String>> ans = new ArrayList(new ArrayList<>());
	        
	        
	        
	        for(int i =0; i<strs.length; i++) {
	        	System.out.println(Arrays.toString(strs));
	        	if(strs[i].isEmpty()) continue;
	        	ArrayList<String> temp  = new ArrayList<>();
	        	temp.add(strs[i]);
	        	for(int j = i+1; j<strs.length; j++) {
	        		if(isAnagram(strs[i], strs[j])) {
	        			temp.add(strs[j]);
	        			strs[j] = "";
	        		}
	        	}
	        	ans.add(temp);
	        }
	        
	        return ans;
	    }
	
	  static boolean isAnagram(String s1, String s2){
		  
	        if(s1.length() != s2.length()) return false;

	        Map<Character,Integer> map = new HashMap<>();

	        for(char c: s1.toCharArray()){
	            if(map.containsKey(c)){
	                map.put(c, map.get(c)+1);
	            }else{
	                map.put(c,1);
	            }
	        }

	        
	        for(char x : s2.toCharArray()){
	            if(map.containsKey(x)){
	                map.put(x,map.get(x)-1);
	            }else{
	                return false;
	            }
	        }
	        

	      for(Map.Entry<Character,Integer> e : map.entrySet()){
	            if(e.getValue()!=0) return false;

	      }

	        return true;
	    }


}
