package com.dsa.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
	
	public static void main(String[] args) {
		
	    //TESTCASE 1
        String[] wordsBank1 = { "ab", "abc","cd","def","abcd"};
        String target1 = "abcdef";
        Map<String,Integer> memo1 = new HashMap<>();
        System.out.println(countConstruct(wordsBank1, target1, memo1)); //true
    
        //TESTCASE 2
        String[] wordsBank2 = {"bo","rd","ate","t","ska","sk","boar"};
        String target2 = "skateboard";
        Map<String,Integer> memo2 = new HashMap<>();
        System.out.println(countConstruct(wordsBank2, target2, memo2)); //false

        //TESTCASE 3
        String[] wordBanks3 = {"e","ee","eee","eeee","eeeee","eeeeee"};
        String target3  = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        Map<String,Integer> memo3 = new HashMap<>();
        System.out.println(countConstruct(wordsBank2, target3,memo3)); //false
        
        //TESTCASE 4
        String[] wordsBank4 = {"a","p","ent","enter","ot","o","t"};
        String target4 = "enterapotentpot";
        Map<String,Integer> memo4 = new HashMap<>();
        System.out.println(countConstruct(wordsBank4, target4,memo4));
		
		
	}
	
	public static int countConstruct(String[] wordBank, String target,Map<String,Integer> memo) {
		
		if(memo.containsKey(target)) return memo.get(target);
		if(target.isEmpty()) return 1;
		
		int totalCount = 0;
		
		for(String word: wordBank) {
			if(target.startsWith(word)) {
				String suffix = target.substring(word.length());
				int numWaysForRest = countConstruct(wordBank, suffix,memo);
				totalCount +=numWaysForRest;
				
			}
		}
		
		memo.put(target, totalCount);
		
		return memo.get(target);
		
	}
	
}
