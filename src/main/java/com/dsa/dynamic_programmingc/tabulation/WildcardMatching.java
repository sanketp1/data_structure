package com.dsa.dynamic_programmingc.tabulation;

/* 
44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.

 
 
 */

public class WildcardMatching {
	
	public static void main(String[] args) {
		
		/*
		 Input: s = "aa", p = "a"
		 Output: false
		 Explanation: "a" does not match the entire string "aa".
		 */
		String s1 = "aa";
		String p1 = "a";
		
		System.out.println(isMatch(s1, p1));
		
		
		/*
		 * Input: s = "aa", p = "*"
		   Output: true
		   Explanation: '*' matches any sequence.
		 */
		String s2 = "aa";
		String p2 = "*";
		System.out.println(isMatch(s2, p2));
		
		/*
		  Input: s = "cb", p = "?a"
		  Output: false
		  Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
		 */
		String s3 = "cb";
		String p3 = "?a";
		System.out.println(isMatch(s3, p3));
		
		
		
		
		
	}
	
	public static boolean isMatch(String s , String p) {
		
		if(p.contains("*")) {
			return true;
		}
		
		
		int j =0;
		while(j<p.length() && j<s.length()) {
			if(s.charAt(j) == p.charAt(j) || p.charAt(j) == '?') {
				j++;
				continue;
			}else {
				return false;
			}
		}
		
		
		return false;
	}
	

}
