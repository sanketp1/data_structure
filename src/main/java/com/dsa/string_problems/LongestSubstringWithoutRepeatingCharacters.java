package com.dsa.string_problems;

import java.util.HashSet;
import java.util.Set;

/*
 
 *Longest Substring Without Repeating Characters*
 
 Given a string s, find the length of the longest 
 substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 
 */

public class LongestSubstringWithoutRepeatingCharacters {
	
   
	public static void main(String[] args) {
		
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int res = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            while (charSet.contains(s.charAt(j))) {
                charSet.remove(s.charAt(i));
                i++;
            }
            charSet.add(s.charAt(j));
            res = Math.max(res, j - i + 1);
        }

        return res;
    }

}
