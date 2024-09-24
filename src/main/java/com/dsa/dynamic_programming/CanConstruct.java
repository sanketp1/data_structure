package com.dsa.dynamic_programming;

import java.util.*;

public class CanConstruct {
    
    public static void main(String[] args) {
        

        //TESTCASE 1
        String[] wordsBank1 = { "ab", "abc","cd","def","abcd"};
        String target1 = "abcdef";
        Map<String,Boolean> memo1 = new HashMap<>();
        System.out.println(canConstruct(wordsBank1, target1, memo1)); //true
    
        //TESTCASE 2
        String[] wordsBank2 = {"bo","rd","ate","t","ska","sk","boar"};
        String target2 = "skateboard";
        Map<String,Boolean> memo2 = new HashMap<>();
        System.out.println(canConstruct(wordsBank2, target2, memo2)); //false

        //TESTCASE 3
        String[] wordBanks3 = {"e","ee","eee","eeee","eeeee","eeeeee"};
        String target3  = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        Map<String,Boolean> memo3 = new HashMap<>();
        System.out.println(canConstruct(wordsBank2, target3,memo3)); //false
        
        //TESTCASE 4
        String[] wordsBank4 = {"a","p","ent","enter","ot","o","t"};
        String target4 = "enterapotentpot";
        Map<String,Boolean> memo4 = new HashMap<>();
        System.out.println(canConstruct(wordsBank4, target4,memo4));
    }

    public static boolean  canConstruct(String[] wordsBank, String target, Map<String,Boolean> memo){
    	
        if(memo.containsKey(target)) return memo.get(target); 
        if(target.isEmpty()) return true;

        for(String word : wordsBank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length(), target.length());
                if(canConstruct(wordsBank, suffix,memo)) {
                	memo.put(target, true);
                	return true;
                }  
            }            
        }
        memo.put(target, false);

        return false;
    }


}
