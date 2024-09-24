package com.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {
	
	
	public static void main(String[] args) {
	    //TESTCASE 1
        String[] wordsBank1 = { "ab", "abc","cd","def","abcd"};
        String target1 = "abcdef";
        Map<String,List<List<String>>> memo1 = new HashMap<>();
        System.out.println(allConstruct(wordsBank1, target1, memo1)); 
    
        //TESTCASE 2
        String[] wordsBank2 = {"bo","rd","ate","t","ska","sk","boar"};
        String target2 = "skateboard";
        Map<String,List<List<String>>> memo2 = new HashMap<>();
        System.out.println(allConstruct(wordsBank2, target2, memo2));

        //TESTCASE 3
        String[] wordBanks3 = {"e","ee","eee","eeee","eeeee","eeeeee"};
        String target3  = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        Map<String,List<List<String>>> memo3 = new HashMap<>();
        System.out.println(allConstruct(wordsBank2, target3,memo3)); 
        
        //TESTCASE 4
        String[] wordsBank4 = {"a","p","ent","enter","ot","o","t"};
        String target4 = "enterapotentpot";
        Map<String,List<List<String>>> memo4 = new HashMap<>();
        System.out.println(allConstruct(wordsBank4, target4,memo4));
	}
	
	
	public static List<List<String>> allConstruct(String[] wordBank,String target,  Map<String,List<List<String>>> memo) {
        
		if(memo.containsKey(target)) return memo.get(target);
		
		if (target.isEmpty()) return new ArrayList(Arrays.asList(new ArrayList<>()));

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(wordBank,suffix,memo);
                List<List<String>> targetWays = new ArrayList<>();
                for (List<String> way : suffixWays) {
                    List<String> subList = new ArrayList<>();
                    subList.add(word);
                    subList.addAll(way);
                    targetWays.add(subList);
                }
                result.addAll(targetWays);
            }
        }
        
        memo.put(target, result);

        return result;
    }
	
}
