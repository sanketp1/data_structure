package com.dsa.string_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
 *Letter Combinations of a Phone Number *

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

public class LetterComibinationPhoneNumber {
	
	public static void main(String[] args) {
		
		String digits = "23";
		
		System.out.println(letterCombinations(digits));
	}
	
	public static List<String> letterCombinations(String digits){
		List<String> ans = new ArrayList<>();
		
		if(digits.isEmpty() || digits.length()==0) return ans;
		
		List<String> splitter = splitter(digits);
		
		
			
				
	  return ans;
	}
	
	public static String f(StringBuilder pre, List<String> strs, int ind) {
		
//		for()
		
		return pre.toString();
	}
		
	public static List<String> splitter(String digits){
        List<String> numStrs = new ArrayList<>();
        String[] mapper = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        for(char c: digits.toCharArray()){
            if(Character.isDigit(c)){
                // Converting character to its integer value
                int n = c - '0';
                numStrs.add(mapper[n]);
            }
        }

        return numStrs;
    }
}
