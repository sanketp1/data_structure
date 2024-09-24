package com.dsa.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

	public static void main(String[] args) {
		
		//TESTCASE 1
		Map<String,Long> memo1 = new HashMap<>();
		System.out.println(gridTraveler(1, 1,memo1));
		
		//TESTCASE 2
		Map<String,Long> memo2 = new HashMap<>();
		System.out.println(gridTraveler(2, 3,memo2));
		
		//TESTCASE 3
		Map<String,Long> memo3 = new HashMap<>();
		System.out.println(gridTraveler(3, 2,memo3));
		
		//TESTCASE 4
		Map<String,Long> memo4 = new HashMap<>();
		System.out.println(gridTraveler(3, 3,memo4));
		
		//TESTCASE 5
		Map<String,Long> memo5 = new HashMap<>();
		System.out.println(gridTraveler(18, 18,memo5));
		
	}
	
	public static long gridTraveler(int row, int col, Map<String,Long> memo ) {
		String key = "("+row+","+col+")";
		if(memo.containsKey(key)) return memo.get(key);
		if(row==1 && col==1) return 1;
		if(row==0 || col==0) return 0;
		long result = gridTraveler(row-1, col,memo) + gridTraveler(row, col-1,memo);
		memo.put(key, result);
		return memo.get(key);
	}
}
